/***
* This class alow to create a chart bar that will be used for article views
* @author: Groupe 5
* @version: 0.0.1
*/

package pkg_utils;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.JPanel;

public class BarChart extends JPanel{

	private static final long serialVersionUID = 1L;
    private Map<Color, Integer> bars = new LinkedHashMap<Color, Integer>();
	
	/**
	* Add new bar to chart
	* @param color color to display bar
	* @param value size of bar
	*/
	public void addBar(Color color, int value){
		bars.put(color, value);
		repaint();
	}

	//Adapted from stackoverflow
	@Override
	protected void paintComponent(Graphics g){
	
		// determine longest bar
		int max = Integer.MIN_VALUE;
		for (Integer value : bars.values()){
			max = Math.max(max, value);
		}
		// paint bars
		int width = (getWidth() / bars.size()) - 2;
		int x = 0;
		for (Color color : bars.keySet()){
			int value = bars.get(color);
			int height = (int)
			((getHeight()-5) * ((double)value / max));
			g.setColor(color);
			g.fillRect(x, getHeight() - height, width, height);
			g.setColor(Color.black);
			g.drawRect(x, getHeight() - height, width, height);
			x += (width + 2);
		}
		
	}
	
}