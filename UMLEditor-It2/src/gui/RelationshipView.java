/**
 * This Class is in charge of drawing the Relationships it will use the manager to get the 
 * data from the Relationships in Manager
 */

package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

import models.ClassObject;
import models.Relationship;

public class RelationshipView {
	private Manager manager;
	private static RelationshipView sharedRelationView;
	private int originX, originY, destinationX, destinationY;
	private ClassObject origin;
	private ClassObject destination;
	private Polygon poly;

	public RelationshipView(Manager manager) {
		this.manager = manager;
	}

	/**
	 * This method will use the Relationship list in manager to display the
	 * relationships depending on their type
	 * 
	 * @param g
	 */
	public void display(Graphics g) {
		if(manager.isOrganize()) {
			for(int i = 0; i < manager.getRelationList().size(); i++) {
				
				manager.getRelationList().get(i).update();
				g.setColor(Color.black);
				originX = manager.getRelationList().get(i).getOriginX();
				originY = manager.getRelationList().get(i).getOriginY();
				destinationX = manager.getRelationList().get(i).getDestinationX();
				destinationY = manager.getRelationList().get(i).getDestinationY();
				origin = manager.getRelationList().get(i).getOrigin();
				destination = manager.getRelationList().get(i).getDestination();
				
				int x1, y1, x2, y2, x3, y3, x4, y4;
				boolean invert = false;
				
				switch (manager.getRelationList().get(i).getRelationshipType()) {
				case 0:
					//set up initial extremes of rectangular line with respect to X
					x1 = Math.min(originX, destinationX);
					if(x1 == originX) {
						y1 = originY;
					} else {
						y1 = destinationY;
					}
					x4 = Math.max(originX, destinationX);
					if(x4 == originX) {
						y4 = originY;
					} else {
							y4 = destinationY;
					}
					x2 = x1 + (x4 - x1) / 2;
					y2 = y1;
					x3 = x2;
					y3 = y4;
					
					//Invert rectangular line
					if(x1 == originX && y1 == originY) {
						if(y4 < origin.getyPos() - 20 || y4 > origin.getyPos() + origin.getHeight() + 20){
							invert = true;
						}
					} else if(x1 == destinationX && y1 == destinationY) {
						if(y4 < destination.getyPos() - 20 || y4 > destination.getyPos() + destination.getHeight() + 20) {
							invert = true;
						}
					}
					if(invert) {
						y1 = Math.min(originY, destinationY);
						if(y1 == originY) {
							x1 = originX;
						} else {
							x1 = destinationX;
						}
						y4 = Math.max(originY, destinationY);
						if(y4 == originY) {
							x4 = originX;
						} else {
								x4 = destinationX;
						}
						y2 = y1 + (y4 - y1) / 2;
						x2 = x1;
						y3 = y2;
						x3 = x4;
					}
					g.drawLine(x1, y1, x2, y2);
					g.drawLine(x2, y2, x3, y3);
					g.drawLine(x3, y3, x4, y4);
					break;
				case 1:
					poly = makeTrianglePolygon();
					
					originX = poly.xpoints[2];
					originY = poly.ypoints[2];
					//set up initial extremes of rectangular line with respect to X
					x1 = Math.min(originX, destinationX);
					if(x1 == originX) {
						y1 = originY;
					} else {
						y1 = destinationY;
					}
					x4 = Math.max(originX, destinationX);
					if(x4 == originX) {
						y4 = originY;
					} else {
							y4 = destinationY;
					}
					x2 = x1 + (x4 - x1) / 2;
					y2 = y1;
					x3 = x2;
					y3 = y4;
					
					//Invert rectangular line
					if(x1 == originX && y1 == originY) {
						if(y4 < origin.getyPos() - 20 || y4 > origin.getyPos() + origin.getHeight() + 20){
							invert = true;
						}
					} else if(x1 == destinationX && y1 == destinationY) {
						if(y4 < destination.getyPos() - 20 || y4 > destination.getyPos() + destination.getHeight() + 20) {
							invert = true;
						}
					}
					if(invert) {
						y1 = Math.min(originY, destinationY);
						if(y1 == originY) {
							x1 = originX;
						} else {
							x1 = destinationX;
						}
						y4 = Math.max(originY, destinationY);
						if(y4 == originY) {
							x4 = originX;
						} else {
								x4 = destinationX;
						}
						y2 = y1 + (y4 - y1) / 2;
						x2 = x1;
						y3 = y2;
						x3 = x4;
					}
					g.drawLine(x1, y1, x2, y2);
					g.drawLine(x2, y2, x3, y3);
					g.drawLine(x3, y3, x4, y4);
					
					g.fillPolygon(poly);
					break;
				case 2:
					poly = makeDiamondPolygon();

					originX = poly.xpoints[2];
					originY = poly.ypoints[2];
					//set up initial extremes of rectangular line with respect to X
					x1 = Math.min(originX, destinationX);
					if(x1 == originX) {
						y1 = originY;
					} else {
						y1 = destinationY;
					}
					x4 = Math.max(originX, destinationX);
					if(x4 == originX) {
						y4 = originY;
					} else {
							y4 = destinationY;
					}
					x2 = x1 + (x4 - x1) / 2;
					y2 = y1;
					x3 = x2;
					y3 = y4;
					
					//Invert rectangular line
					if(x1 == originX && y1 == originY) {
						if(y4 < origin.getyPos() - 20 || y4 > origin.getyPos() + origin.getHeight() + 20){
							invert = true;
						}
					} else if(x1 == destinationX && y1 == destinationY) {
						if(y4 < destination.getyPos() - 20 || y4 > destination.getyPos() + destination.getHeight() + 20) {
							invert = true;
						}
					}
					if(invert) {
						y1 = Math.min(originY, destinationY);
						if(y1 == originY) {
							x1 = originX;
						} else {
							x1 = destinationX;
						}
						y4 = Math.max(originY, destinationY);
						if(y4 == originY) {
							x4 = originX;
						} else {
								x4 = destinationX;
						}
						y2 = y1 + (y4 - y1) / 2;
						x2 = x1;
						y3 = y2;
						x3 = x4;
					}
					g.drawLine(x1, y1, x2, y2);
					g.drawLine(x2, y2, x3, y3);
					g.drawLine(x3, y3, x4, y4);
					g.drawPolygon(poly);
					break;
				case 3:
					poly = makeDiamondPolygon();

					originX = poly.xpoints[2];
					originY = poly.ypoints[2];
					//set up initial extremes of rectangular line with respect to X
					x1 = Math.min(originX, destinationX);
					if(x1 == originX) {
						y1 = originY;
					} else {
						y1 = destinationY;
					}
					x4 = Math.max(originX, destinationX);
					if(x4 == originX) {
						y4 = originY;
					} else {
							y4 = destinationY;
					}
					x2 = x1 + (x4 - x1) / 2;
					y2 = y1;
					x3 = x2;
					y3 = y4;
					
					//Invert rectangular line
					if(x1 == originX && y1 == originY) {
						if(y4 < origin.getyPos() - 20 || y4 > origin.getyPos() + origin.getHeight() + 20){
							invert = true;
						}
					} else if(x1 == destinationX && y1 == destinationY) {
						if(y4 < destination.getyPos() - 20 || y4 > destination.getyPos() + destination.getHeight() + 20) {
							invert = true;
						}
					}
					if(invert) {
						y1 = Math.min(originY, destinationY);
						if(y1 == originY) {
							x1 = originX;
						} else {
							x1 = destinationX;
						}
						y4 = Math.max(originY, destinationY);
						if(y4 == originY) {
							x4 = originX;
						} else {
								x4 = destinationX;
						}
						y2 = y1 + (y4 - y1) / 2;
						x2 = x1;
						y3 = y2;
						x3 = x4;
					}
					g.drawLine(x1, y1, x2, y2);
					g.drawLine(x2, y2, x3, y3);
					g.drawLine(x3, y3, x4, y4);
					g.fillPolygon(poly);
					break;
				case 4:
					poly = makeTrianglePolygon();

					originX = poly.xpoints[2];
					originY = poly.ypoints[2];
					//set up initial extremes of rectangular line with respect to X
					x1 = Math.min(originX, destinationX);
					if(x1 == originX) {
						y1 = originY;
					} else {
						y1 = destinationY;
					}
					x4 = Math.max(originX, destinationX);
					if(x4 == originX) {
						y4 = originY;
					} else {
							y4 = destinationY;
					}
					x2 = x1 + (x4 - x1) / 2;
					y2 = y1;
					x3 = x2;
					y3 = y4;
					
					//Invert rectangular line
					if(x1 == originX && y1 == originY) {
						if(y4 < origin.getyPos() - 20 || y4 > origin.getyPos() + origin.getHeight() + 20){
							invert = true;
						}
					} else if(x1 == destinationX && y1 == destinationY) {
						if(y4 < destination.getyPos() - 20 || y4 > destination.getyPos() + destination.getHeight() + 20) {
							invert = true;
						}
					}
					if(invert) {
						y1 = Math.min(originY, destinationY);
						if(y1 == originY) {
							x1 = originX;
						} else {
							x1 = destinationX;
						}
						y4 = Math.max(originY, destinationY);
						if(y4 == originY) {
							x4 = originX;
						} else {
								x4 = destinationX;
						}
						y2 = y1 + (y4 - y1) / 2;
						x2 = x1;
						y3 = y2;
						x3 = x4;
					}
					g.drawLine(x1, y1, x2, y2);
					g.drawLine(x2, y2, x3, y3);
					g.drawLine(x3, y3, x4, y4);
					g.drawPolygon(poly);
					break;
				}
			}
		} else {
			for (int i = 0; i < manager.getRelationList().size(); i++) {
	
				manager.getRelationList().get(i).update();
				g.setColor(Color.black);
				originX = manager.getRelationList().get(i).getOriginX();
				originY = manager.getRelationList().get(i).getOriginY();
				destinationX = manager.getRelationList().get(i).getDestinationX();
				destinationY = manager.getRelationList().get(i).getDestinationY();
				origin = manager.getRelationList().get(i).getOrigin();
				destination = manager.getRelationList().get(i).getDestination();
	
				switch (manager.getRelationList().get(i).getRelationshipType()) {
				case 0:
					g.drawLine(originX, originY, destinationX, destinationY);
					break;
				case 1:
					poly = makeTrianglePolygon();
					g.drawLine(poly.xpoints[2], poly.ypoints[2], destinationX,
							destinationY);
					g.fillPolygon(poly);
					break;
				case 2:
					poly = makeDiamondPolygon();
					g.drawLine(poly.xpoints[2], poly.ypoints[2], destinationX,
							destinationY);
					g.drawPolygon(poly);
					break;
				case 3:
					poly = makeDiamondPolygon();
					g.drawLine(poly.xpoints[2], poly.ypoints[2], destinationX,
							destinationY);
					g.fillPolygon(poly);
					break;
				case 4:
					poly = makeTrianglePolygon();
					g.drawLine(poly.xpoints[2], poly.ypoints[2], destinationX,
							destinationY);
					g.drawPolygon(poly);
					break;
				}
	
			}
		}

	}

	/**
	 * This method makes sure that only one instance of the RelationshipView is
	 * created as a singleton.
	 * 
	 * @param manager
	 * @return
	 */
	public static RelationshipView sharedInstance(Manager manager) {
		if (sharedRelationView == null) {
			sharedRelationView = new RelationshipView(manager);
		}
		return sharedRelationView;
	}

	/**
	 * This method will return a polygon with the path to draw a triangle
	 * 
	 * @return
	 */
	public Polygon makeTrianglePolygon() {

		int[] xPoints = new int[4];
		int[] yPoints = new int[4];

		if (destinationY > (origin.getyPos() + origin.getHeight())
				&& (destinationX >= origin.getxPos() - 30 && destinationX <= (origin
						.getxPos() + origin.getWidth() + 30))) {
			xPoints[0] = origin.getxPos() + (origin.getWidth() / 2);
			yPoints[0] = origin.getyPos() + origin.getHeight();
			xPoints[1] = xPoints[0] + 10;
			yPoints[1] = yPoints[0] + 10;
			xPoints[2] = xPoints[1] - 10;
			yPoints[2] = yPoints[1];
			xPoints[3] = xPoints[2] - 10;
			yPoints[3] = yPoints[2];
		} else if (destinationX > (origin.getxPos() + origin.getWidth() + 30)) {
			xPoints[0] = origin.getxPos() + origin.getWidth();
			yPoints[0] = origin.getyPos() + (origin.getHeight() / 2);
			xPoints[1] = xPoints[0] + 10;
			yPoints[1] = yPoints[0] - 10;
			xPoints[2] = xPoints[1];
			yPoints[2] = yPoints[1] + 10;
			xPoints[3] = xPoints[2];
			yPoints[3] = yPoints[2] + 10;
		} else if (destinationY < origin.getyPos()
				&& (destinationX >= origin.getxPos() - 30 && destinationX <= (origin
						.getxPos() + origin.getWidth() + 30))) {
			xPoints[0] = origin.getxPos() + (origin.getWidth() / 2);
			yPoints[0] = origin.getyPos();
			xPoints[1] = xPoints[0] - 10;
			yPoints[1] = yPoints[0] - 10;
			xPoints[2] = xPoints[1] + 10;
			yPoints[2] = yPoints[1];
			xPoints[3] = xPoints[2] + 10;
			yPoints[3] = yPoints[2];
		} else if (destinationX < (origin.getxPos() - 30)) {
			xPoints[0] = origin.getxPos();
			yPoints[0] = origin.getyPos() + (origin.getHeight() / 2);
			xPoints[1] = xPoints[0] - 10;
			yPoints[1] = yPoints[0] + 10;
			xPoints[2] = xPoints[1];
			yPoints[2] = yPoints[1] - 10;
			xPoints[3] = xPoints[2];
			yPoints[3] = yPoints[2] - 10;
		}

		Polygon poly = new Polygon(xPoints, yPoints, 4);

		return poly;
	}

	/**
	 * This method will return a polygon with the path to draw a diamond
	 * 
	 * @return
	 */
	public Polygon makeDiamondPolygon() {

		int[] xPoints = new int[4];
		int[] yPoints = new int[4];

		if (destinationY > (origin.getyPos() + origin.getHeight())
				&& (destinationX >= origin.getxPos() - 30 && destinationX <= (origin
						.getxPos() + origin.getWidth() + 30))) {
			xPoints[0] = origin.getxPos() + (origin.getWidth() / 2);
			yPoints[0] = origin.getyPos() + origin.getHeight();
			xPoints[1] = xPoints[0] + 10;
			yPoints[1] = yPoints[0] + 10;
			xPoints[2] = xPoints[1] - 10;
			yPoints[2] = yPoints[1] + 10;
			xPoints[3] = xPoints[2] - 10;
			yPoints[3] = yPoints[2] - 10;
		} else if (destinationX > (origin.getxPos() + origin.getWidth() + 30)) {
			xPoints[0] = origin.getxPos() + origin.getWidth();
			yPoints[0] = origin.getyPos() + (origin.getHeight() / 2);
			xPoints[1] = xPoints[0] + 10;
			yPoints[1] = yPoints[0] - 10;
			xPoints[2] = xPoints[1] + 10;
			yPoints[2] = yPoints[1] + 10;
			xPoints[3] = xPoints[2] - 10;
			yPoints[3] = yPoints[2] + 10;
		} else if (destinationY < origin.getyPos()
				&& (destinationX >= origin.getxPos() - 30 && destinationX <= (origin
						.getxPos() + origin.getWidth() + 30))) {
			xPoints[0] = origin.getxPos() + (origin.getWidth() / 2);
			yPoints[0] = origin.getyPos();
			xPoints[1] = xPoints[0] - 10;
			yPoints[1] = yPoints[0] - 10;
			xPoints[2] = xPoints[1] + 10;
			yPoints[2] = yPoints[1] - 10;
			xPoints[3] = xPoints[2] + 10;
			yPoints[3] = yPoints[2] + 10;
		} else if (destinationX < (origin.getxPos() - 30)) {
			xPoints[0] = origin.getxPos();
			yPoints[0] = origin.getyPos() + (origin.getHeight() / 2);
			xPoints[1] = xPoints[0] - 10;
			yPoints[1] = yPoints[0] + 10;
			xPoints[2] = xPoints[1] - 10;
			yPoints[2] = yPoints[1] - 10;
			xPoints[3] = xPoints[2] + 10;
			yPoints[3] = yPoints[2] - 10;
		}

		Polygon poly = new Polygon(xPoints, yPoints, 4);

		return poly;
	}

}
