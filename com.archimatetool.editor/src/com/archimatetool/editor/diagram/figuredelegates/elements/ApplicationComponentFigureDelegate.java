package com.archimatetool.editor.diagram.figuredelegates.elements;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Pattern;

import com.archimatetool.editor.diagram.figuredelegates.AbstractFigureDelegate;
import com.archimatetool.editor.diagram.figures.FigureUtils;
import com.archimatetool.editor.diagram.figures.IDiagramModelObjectFigure;
import com.archimatetool.editor.preferences.IPreferenceConstants;
import com.archimatetool.editor.preferences.Preferences;
import com.archimatetool.editor.ui.ColorFactory;

public class ApplicationComponentFigureDelegate extends AbstractPolygonalFigureDelegate {
	
    protected static final int INDENT = 10;

	public ApplicationComponentFigureDelegate(IDiagramModelObjectFigure owner) {
		super(owner);
	}
	
	@Override
    public void drawFigure(Graphics graphics) {
        
        graphics.pushState();
        
        Rectangle bounds = getBounds().getCopy();
        
        if(!isEnabled()) {
            setDisabledState(graphics);
        }
        
        // Main Fill
        graphics.setBackgroundColor(getFillColor());
        
        Pattern gradient = null;
        if(Preferences.STORE.getBoolean(IPreferenceConstants.SHOW_GRADIENT)) {
            gradient = FigureUtils.createGradient(graphics, bounds, getFillColor());
            graphics.setBackgroundPattern(gradient);
        }

        graphics.fillRectangle(bounds.x + INDENT, bounds.y, bounds.width - INDENT, bounds.height);
        
        if(gradient != null) {
            gradient.dispose();
        }
        
        // Outline
        graphics.setForegroundColor(getLineColor());
        PointList points = new PointList();
        Point pt1 = new Point(bounds.x + INDENT, bounds.y + 10);
        points.addPoint(pt1);
        Point pt2 = new Point(pt1.x, bounds.y);
        points.addPoint(pt2);
        Point pt3 = new Point(bounds.x + bounds.width - 1, bounds.y);
        points.addPoint(pt3);
        Point pt4 = new Point(pt3.x, bounds.y + bounds.height - 1);
        points.addPoint(pt4);
        Point pt5 = new Point(pt1.x, pt4.y);
        points.addPoint(pt5);
        Point pt6 = new Point(pt1.x, bounds.y + 42);
        points.addPoint(pt6);
        graphics.drawPolyline(points);
        graphics.drawLine(bounds.x + INDENT, bounds.y + 22, bounds.x + INDENT, bounds.y + 30);
        
        // Nubs Fill
        graphics.setBackgroundColor(ColorFactory.getDarkerColor(getFillColor()));
        graphics.fillRectangle(bounds.x, bounds.y + 10, INDENT * 2 + 1, 13);
        graphics.fillRectangle(bounds.x, bounds.y + 30, INDENT * 2 + 1, 13);
        
        // Nubs Outline
        graphics.setForegroundColor(getLineColor());
        graphics.drawRectangle(bounds.x, bounds.y + 10, INDENT * 2, 12);
        graphics.drawRectangle(bounds.x, bounds.y + 30, INDENT * 2, 12);
        
        graphics.popState();
    }
	
	@Override
    public Rectangle calculateTextControlBounds() {   
        Rectangle bounds = getBounds().getCopy();
        bounds.x += 18;
        bounds.width -= 18;
        return bounds;      
    }

	@Override
	public void drawShape(Graphics graphics) {
        graphics.pushState();
        
        Rectangle bounds = getBounds().getCopy();
        
     // Main Fill
        graphics.fillRectangle(bounds.x + INDENT, bounds.y, bounds.width - INDENT, bounds.height);
        
     // Outline
        PointList points = getPoints();
        graphics.drawPolyline(points);
        graphics.drawLine(bounds.x + INDENT, bounds.y + 22, bounds.x + INDENT, bounds.y + 30);
        
     // Nubs Fill
        graphics.fillRectangle(bounds.x, bounds.y + 10, INDENT * 2 + 1, 13);
        graphics.fillRectangle(bounds.x, bounds.y + 30, INDENT * 2 + 1, 13);
        
     // Nubs Outline
        graphics.drawRectangle(bounds.x, bounds.y + 10, INDENT * 2, 12);
        graphics.drawRectangle(bounds.x, bounds.y + 30, INDENT * 2, 12);
        
        graphics.popState();

	}

	@Override
	public PointList getPoints() {
		Rectangle bounds = getBounds().getCopy();
		
		PointList points = new PointList();
		
        Point pt1 = new Point(bounds.x + INDENT, bounds.y + 10);
        points.addPoint(pt1);
        Point pt2 = new Point(pt1.x, bounds.y);
        points.addPoint(pt2);
        Point pt3 = new Point(bounds.x + bounds.width - 1, bounds.y);
        points.addPoint(pt3);
        Point pt4 = new Point(pt3.x, bounds.y + bounds.height - 1);
        points.addPoint(pt4);
        Point pt5 = new Point(pt1.x, pt4.y);
        points.addPoint(pt5);
        Point pt6 = new Point(pt1.x, bounds.y + 42);
        points.addPoint(pt6);
        
        return points;
	}

}
