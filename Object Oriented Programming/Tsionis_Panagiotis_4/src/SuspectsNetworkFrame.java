import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.shortestpath.DistanceStatistics;
import edu.uci.ics.jung.graph.SparseGraph;
import edu.uci.ics.jung.visualization.VisualizationImageServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;

public class SuspectsNetworkFrame extends JFrame {
	
	private SparseGraph graph;
	private JPanel panel;
	private JTextField diameterField;
	private ArrayList<Suspect> suspects = new ArrayList<>();
	
	public SuspectsNetworkFrame(Registry aRegistry) {
		suspects = aRegistry.getSuspects();
		graph = new SparseGraph();
		
		//Creation of a new graph that every suspect will be a node
		for(Suspect aSuspect : suspects) {
			graph.addVertex(aSuspect.getCodeName());
		}
		
		//Creation of connections between suspects, based on who is a partner with who, as shown in registry
		Integer counterEdge = 1;
		for(Suspect aSuspect : suspects) {
			ArrayList<Suspect> partners = new ArrayList<>();
			partners = aSuspect.getPartners();
			//Creation of edges, every edge will be named as EdgeX, where X equals the number of the counterEdge
			for (Suspect partner : partners) {
				graph.addEdge("Edge"+counterEdge, aSuspect.getCodeName(), partner.getCodeName());
				counterEdge++;
			}
		}
		
		VisualizationImageServer vs = new VisualizationImageServer(new CircleLayout(graph), new Dimension(400,450));
		//Used to show the codeName of every node (suspect) in the graph
		vs.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
		
		//Creation of the text field where the diameter of the graph will be shown
		Double graphDiameter = DistanceStatistics.diameter(graph);
		diameterField = new JTextField("Diameter = "+graphDiameter.toString(), 5);
		
		//Creation of the panel
		panel = new JPanel(new BorderLayout());
		panel.add(vs);
		panel.add(diameterField, BorderLayout.PAGE_END);
		this.setContentPane(panel);
		
		this.setVisible(true);
		this.setSize(500,550);
		this.setTitle("Suspects Netowrk");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
//Big thanks to Google and The Internet :D
