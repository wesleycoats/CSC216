package edu.ncsu.csc216.shipping_simulator.ui;

import java.util.ArrayList;
import java.util.Hashtable;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import edu.ncsu.csc216.shipping_simulator.simulation.Simulator;

/**
 * Animates simulations of book shipments through a collection of shipment stations.
 * @author Jo Perry
 * @version 2.0
 */
public class SimulationViewer extends JFrame implements ActionListener, ChangeListener { 
	
	// ID used for serialization
	private static final long serialVersionUID = 1L;
	
	// Size constants for the window and panels
	private final static int FRAME_WIDTH = 950;  // Application window width
	private final static int FRAME_HEIGHT = 600; // Application window height
	private final static int GRAPH_WIDTH = 650;  // Simulation graph width
	private final static int GRAPH_HEIGHT = 550;  // Simulation graph height
	private final static int SCREEN_OFFSET = 100; // Placement of application window on screen
	private final static int PAD = 20; // Offset padding	
	
	//	Strings for window, labels, slider, and combo
	private final static String TITLE = "Book Shipping Center Simulation"; 
	private final static String INPUT_PACKAGES = "Number of Book Packages: ";
	private final static String START = "Start";
	private final static String QUIT = "Quit";
	private final static String BLANK = "";
	private final static String WAIT_TIME = "Average Wait Time: ";
	private final static String PROCESS_TIME = "Average Process Time: ";
	private final static String NUMBER_OF_STATIONS = "Number of Process Stations: ";
	private final static String ANIMATION_SPEED  = "Animation Speed: ";
	private final static String PROGRESS = "Progress: ";
	private final static String GO_SLOW = "Slow";
	private final static String GO_FAST = "Fast";
	private final static String[] LABEL_STATION_NUMBERS = {"3", "4", "5", "6", "7", "8", "9"};
	
	// Constants for animation
	private final static int PACKAGE_WIDTH = 12; // Radius of circle that represents a simulation item
	private final static int SLOW = 500; // Thread sleep for slow animation
	private final static int FAST = 0;  // Thread sleep for fast animation
	private final static Color CENTER_COLOR = Color.YELLOW;
	private final static Color CENTER_COLOR_ALTERNATE = Color.MAGENTA;
	
	// Buttons 
	private JButton btnStart = new JButton(START); // Start a new simulation
	private JButton btnQuit = new JButton(QUIT); // Quit execution	

	// Labels
	private final JLabel lblNumPackages = new JLabel(INPUT_PACKAGES);
	private final JLabel lblSpeed = new JLabel(ANIMATION_SPEED);
	private final JLabel lblSlow = new JLabel(GO_SLOW);
	private final JLabel lblFast = new JLabel(GO_FAST);	
	private final JLabel lblWaitTime = new JLabel(WAIT_TIME);
	private final JLabel lblProcessTime = new JLabel(PROCESS_TIME);
	private final JLabel lblProgress = new JLabel(PROGRESS);
	private final JLabel lblNumStations = new JLabel(NUMBER_OF_STATIONS);
	private JLabel lblWaitCalc = new JLabel(BLANK);
	private JLabel lblProcessCalc = new JLabel(BLANK);		

	// Fields for user input and results
	private JTextField txtNumPackages = new JTextField("100");
	private JComboBox<String> cmbStations = new JComboBox<String>(LABEL_STATION_NUMBERS);
	private JSlider slideSleep = new JSlider(JSlider.HORIZONTAL, FAST, SLOW, (FAST + SLOW) / 2);
	private int sleepTime = 100;
	private JProgressBar progress = new JProgressBar();
	
	// Bookkeeping members
	private static Hashtable<Integer, JLabel> sleepTimeLabel = new Hashtable<Integer, JLabel>();	
	private ArrayList<Color>[] laneColors;
	
	// Panels
	private JPanel pnlButtons = new JPanel(new FlowLayout());   // Start, quit buttons
	private JPanel pnlSimulation = new JPanel(); // Simulation animation
	private JPanel pnlBottom = new JPanel(); // Groups bottom panels
	private JPanel pnlInput = new JPanel();  // Input widgets
	private JPanel pnlOutput = new JPanel(); // Simulation results

	// Backend and backend parameters
	private int numberOfPackages; // Number of book packages in a simulation run
	private int numberOfStations; // Number of process stations in a simulation run 
	private Simulator simulator; // Shipment simulator
	
	/** 
	 * Creates the user interface for the application.
	 */
	public SimulationViewer() {
		// Initial work. Set up the buttons and the panels
		addListeners();
		setUpInputPanels();
		
		// Add the panels to the window. Set its size, location, title
		Container c = getContentPane();
		c.add(pnlButtons, BorderLayout.NORTH);
		c.add(pnlSimulation, BorderLayout.CENTER);
		c.add(pnlBottom, BorderLayout.SOUTH);
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setLocation(SCREEN_OFFSET, SCREEN_OFFSET);	
		setTitle(TITLE);

		// Finish setting up the frame. Exit the application when the user closes the window.
		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Specifies actions to be performed when the user clicks a button or selects from a combo box.
	 * @param e Source is the button clicked.
	 */
	public void actionPerformed(ActionEvent e) {
		// Run the simulation when the user clicks the start button 
		if (e.getSource() == btnStart){
			btnStart.setEnabled(false);

			// Clear off current information and get parameters for the new simulation run
			clearSimulationPanel();
			clearLabel(lblWaitCalc);
			clearLabel(lblProcessCalc);   

			// Set up the simulator, run it, and show the results
			try {
				numberOfPackages = Integer.parseInt(txtNumPackages.getText());
				numberOfStations = Integer.parseInt((String)cmbStations.getSelectedItem());
				simulator = new Simulator (numberOfStations, numberOfPackages);              
				run();
				lblWaitCalc.setText(String.format("%1$.2f seconds", simulator.averageWaitTime()));
				lblProcessCalc.setText(String.format("%1$.2f seconds", simulator.averageProcessTime()));
				btnStart.setEnabled(true);
			} catch (NumberFormatException nfe) {
				showErrorMessage("The number of packages must be an integer.");
			} catch (IllegalArgumentException iae) {
				showErrorMessage("There must be at least one package in the simulation.");
			}
		}
		// Pick up the number of loading docks from the combo box
		if (e.getSource() == cmbStations) {
			int x = cmbStations.getSelectedIndex();
			numberOfStations = Integer.parseInt(LABEL_STATION_NUMBERS[x]);
		}
		// Quit program execution
		if (e.getSource() == btnQuit) {
			System.exit(0);
		}
	}
	   
	/**
	 * Determines whether the user changed the animation speed.
	 * @param e the ChangeEvent object generated when slide is interacted with
	 */
	public void stateChanged(ChangeEvent e) {
		if (e.getSource().equals(slideSleep)) {
			sleepTime = SLOW - slideSleep.getValue();
		}
	}

//-----------------------Private Methods, Classes--------------------------------------------------
	/**
	 * Private method. Creates a dialog box for a simulation initialization error.
	 * @param message message to show in the dialog box
	 */
	private void showErrorMessage(String message) {
		JOptionPane.showMessageDialog(null, message, "Simulation Initialization Error", JOptionPane.PLAIN_MESSAGE);
		btnStart.setEnabled(true);
		txtNumPackages.setText("");
	}	
	
	/** 
	 * Private method. Adds listeners to the button, combo box, and slider bar
	 */
	private void addListeners(){
		btnStart.addActionListener(this);
		btnQuit.addActionListener(this);
		cmbStations.addActionListener(this);
		slideSleep.addChangeListener(this);
	}  
	
	/**
	 * Private method. Sets up the slider that controls speed of animation
	 */
	private void setUpSlider() {
		sleepTimeLabel.put(Integer.valueOf(SLOW), lblFast);
		sleepTimeLabel.put(Integer.valueOf(FAST), lblSlow);
		slideSleep.setLabelTable(sleepTimeLabel);
		slideSleep.setPaintLabels(true);
	}
	
	/**
	 * Private method. Set up progress bar.
	 */
	private void setUpProgressBar() {
		progress = new JProgressBar( );
		progress.setPreferredSize( new Dimension( 100, 20 ) );
		progress.setBounds( 0, 0, 100, 20 );		
	}
	
	/**
	 * Private method. Right aligns a label and adds it to the panel
	 * @param panel panel doing the add
	 * @param label label being right aligned
	 */
	private void addAndAlign(JPanel panel, JLabel label) {
		label.setHorizontalAlignment(JLabel.RIGHT);
		panel.add(label);
	}

	/**
	 * Private method. Puts widgets on the panels
	 */
	private void setUpInputPanels() {
		pnlSimulation.setBackground(Color.WHITE);
		pnlSimulation.setPreferredSize(new Dimension(GRAPH_WIDTH, GRAPH_HEIGHT));
		pnlButtons.add(btnStart);
		pnlButtons.add(btnQuit);
		
		// Add labels, progress bar for results
		pnlOutput.setBorder((EmptyBorder) BorderFactory.createEmptyBorder( PAD, PAD / 2, PAD, PAD));
		pnlOutput.setLayout(new GridLayout(3, 2));
		addAndAlign(pnlOutput, lblWaitTime);
		pnlOutput.add(lblWaitCalc);
		addAndAlign(pnlOutput, lblProcessTime);
		pnlOutput.add(lblProcessCalc);
		addAndAlign(pnlOutput, lblProgress);
		setUpProgressBar();
		pnlOutput.add(progress);			

		// Add labels, text field, combo, slider for user input
		pnlInput.setBorder((EmptyBorder) BorderFactory.createEmptyBorder( PAD, PAD / 2, PAD, PAD));
		pnlInput.setLayout(new GridLayout(3, 2));
		addAndAlign(pnlInput, lblNumPackages);
		pnlInput.add(txtNumPackages);
		addAndAlign(pnlInput, lblNumStations);
		pnlInput.add(cmbStations);
		addAndAlign(pnlInput, lblSpeed);
		setUpSlider();
		pnlInput.add(slideSleep);
		
		// Complete the bottom panel
		pnlBottom.setLayout(new BoxLayout(pnlBottom, BoxLayout.LINE_AXIS));
		pnlBottom.add(pnlInput);
		pnlBottom.add(pnlOutput);	
	}
	
	/**
	 * Private method. Erases everything on the simulation panel
	 */
	private void clearSimulationPanel() {
		Graphics brush = pnlSimulation.getGraphics();
		brush.setColor(Color.white);
		brush.fillRect(0, 0, pnlSimulation.getWidth(), pnlSimulation.getHeight());		
	}
	
	/**
	 * Private method. Immediately sets the text for a label to blank.
	 * @param lbl the label being cleared
	 */
	private void clearLabel(JLabel lbl){
		lbl.setText(BLANK);
		Rectangle rectLbl = lbl.getBounds();
		rectLbl.x = 0;
		rectLbl.y = 0;
		lbl.paintImmediately(rectLbl);
	}
		
	/**
	 * Private method. Animates the simulation and shows the results.
	 */
	private void run()  {
		// Draw the process stations and set up for animating their waiting lines
		drawSystem(pnlSimulation, numberOfStations);				
		laneColors = new ColorQueue[numberOfStations];
		for (int k = 0; k < numberOfStations; k++) {
			laneColors[k] = new ColorQueue();
		}
		// "Decorate" every other package of books. The variable decorated keeps track of whether the 
		//    rear package is decorated
		boolean[] decorated = new boolean[numberOfStations]; 
		for (int k = 0; k < numberOfStations; k++) {
			decorated[k] = false;
		}
		
		// Prepare the progress bar
		progress.setMinimum(0);
		progress.setValue(0);
		progress.setMaximum(simulator.totalNumberOfSteps());

		// Step through the simulation
		while (simulator.moreSteps()) {
			simulator.step();
			int soFar = simulator.getStepsTaken();
			int index = simulator.getCurrentIndex();
			int length = laneColors[index].size();
			if (simulator.itemLeftSimulation()) {
				laneColors[index].remove(0);
				decorated[index] = !decorated[index];
			}
			else {
				laneColors[index].add(simulator.getCurrentShipmentColor());
			}
			
			// Erase the last package on the station line that changed on this step
			//   (needed only if the package leaves the station line)
			plotPoint(pnlSimulation, (index + 1) * GRAPH_WIDTH / (numberOfStations + 1), 
					20 + 12 * (length - 1), Color.WHITE, false);
			// Redraw the line that changed, marking every other package with a dot so you
			//   can detect the motion
			int j = 0;
			boolean colorMarker = false;
			for (Color dotColor : laneColors[index]) {
				plotPoint(pnlSimulation, (index + 1) * GRAPH_WIDTH / (numberOfStations + 1), 
						20 + 12 * j++, dotColor, colorMarker ^ decorated[index]);
				colorMarker = !colorMarker;
			}
			// Update the progress bar
			progress.setValue(soFar);
			Rectangle progressRect = progress.getBounds();
			progressRect.x = 0;
			progressRect.y = 0;
			progress.paintImmediately( progressRect );

			// Slow down the animation
			try {
				Thread.sleep(sleepTime);
			}
			catch ( InterruptedException e) {
				//Do nothing
			}
		}          
	}			

	/** 
	 * Private method. Sets up the panels by specifying sizes and borders and adding components.
	 */
	private void drawSystem(JPanel panel, int lanes) {
		Graphics g = panel.getGraphics();
		g.setColor(Color.BLACK);
		// Draw the loading docks
		for (int k = 0; k < lanes; k++) {
			g.drawRect((k + 1) * GRAPH_WIDTH / (lanes + 1) - 1, 19, 
					PACKAGE_WIDTH + 2, PACKAGE_WIDTH + 2); 
		}
	}

	/**
	 * Private method. Plots a solid circle on a graph.
	 * @param panel Panel where the graph is drawn.
	 * @param x x-coordinate of the point
	 * @param y y-coordinate of the point
	 * @param c color of the point
	 * @param withHole determines whether there should be a whole in the circle
	 */
	private void plotPoint(JPanel panel, int x, int y, Color c, boolean withHole) {
		Graphics g = panel.getGraphics();
		g.setColor(c);
		g.fillOval(x, y, PACKAGE_WIDTH, PACKAGE_WIDTH);
		if (withHole) {
			if (c == CENTER_COLOR)
				g.setColor(CENTER_COLOR_ALTERNATE);
			else
				g.setColor(CENTER_COLOR);
			g.fillOval(x + PACKAGE_WIDTH / 4 + 1, y + PACKAGE_WIDTH / 4 + 1, PACKAGE_WIDTH / 3, PACKAGE_WIDTH / 3);	
		}
	}

	/**
	 * Private inner class to set up equivalent of a C typedef for an ArrayList of Color objects.
	 */
	private static class ColorQueue extends ArrayList<Color> {
		private static final long serialVersionUID = 1L;	
	}
	
//-------------------End Private Methods, Classes--------------------------------------------------
	
	/**
	 * Main method. Instantiates the Simulation
	 * @param args Not used.
	 */
	public static void main(String[] args) {
		new SimulationViewer();
	}
}