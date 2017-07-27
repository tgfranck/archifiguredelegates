package com.archimatetool.editor.diagram.figuredelegates.elements;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;

import com.archimatetool.editor.diagram.figures.IDiagramModelObjectFigure;
import com.archimatetool.editor.diagram.figures.RoundedRectangleFigureDelegate;

public class ProcessRoundedRectangleFigureDelegate extends RoundedRectangleFigureDelegate {

	public ProcessRoundedRectangleFigureDelegate(IDiagramModelObjectFigure owner) {
		super(owner, 15);
	}
	
	public void drawFigure(Graphics graphics){
		super.drawFigure(graphics);
		drawIcon(graphics);
	}
	
	/**
     * Draw the icon
     */
    protected void drawIcon(Graphics graphics) {
        graphics.pushState();
        
        graphics.setLineWidth(1);
        graphics.setForegroundColor(isEnabled() ? ColorConstants.black : ColorConstants.gray);
        
        PointList points = new PointList();
        
        // Start at top left
        Point pt = getIconOrigin();
        points.addPoint(pt);
        
        pt.translate(8, 0);
        points.addPoint(pt);
        
        pt.translate(0, -3);
        points.addPoint(pt);
        
        pt.translate(6, 5);
        points.addPoint(pt);
        
        pt.translate(-6, 5);
        points.addPoint(pt);
        
        pt.translate(0, -3);
        points.addPoint(pt);
        
        pt.translate(-8, 0);
        points.addPoint(pt);
        
        graphics.drawPolygon(points);
        
        graphics.popState();
    }
    
    /**
     * @return The icon start position
     */
    protected Point getIconOrigin() {
        Rectangle bounds = getBounds();
        return new Point(bounds.x + bounds.width - 18, bounds.y + 11);
    }

}
