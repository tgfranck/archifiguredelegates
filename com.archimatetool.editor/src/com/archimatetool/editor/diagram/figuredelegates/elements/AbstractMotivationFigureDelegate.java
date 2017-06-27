package com.archimatetool.editor.diagram.figuredelegates.elements;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Pattern;

import com.archimatetool.editor.diagram.figures.AbstractFigureDelegate;
import com.archimatetool.editor.diagram.figures.FigureUtils;
import com.archimatetool.editor.diagram.figures.IDiagramModelObjectFigure;
import com.archimatetool.editor.preferences.IPreferenceConstants;
import com.archimatetool.editor.preferences.Preferences;

public class AbstractMotivationFigureDelegate extends AbstractFigureDelegate {
	
    protected static final int FLANGE = 10;

	public AbstractMotivationFigureDelegate(IDiagramModelObjectFigure owner) {
		super(owner);
	}
	
	@Override
    public void drawFigure(Graphics graphics) {

        graphics.pushState();
        
        Rectangle bounds = getBounds();
        
        PointList points = new PointList();
 
        int x = bounds.x;
        int y = bounds.y;
        int width = bounds.width - 1;
        int height = bounds.height - 1;
        
        points.addPoint(x + FLANGE, y);
        points.addPoint(x + width - FLANGE, y);
        points.addPoint(x + width, y + FLANGE);
        points.addPoint(x + width, y + height - FLANGE);
        points.addPoint(x + width - FLANGE, y + height);
        points.addPoint(x + FLANGE, y + height);
        points.addPoint(x, y + height - FLANGE);
        points.addPoint(x, y + FLANGE);
        
        if(!isEnabled()) {
            setDisabledState(graphics);
        }
        
        // Fill
        graphics.setBackgroundColor(getFillColor());
        
        Pattern gradient = null;
        if(Preferences.STORE.getBoolean(IPreferenceConstants.SHOW_GRADIENT)) {
            gradient = FigureUtils.createGradient(graphics, bounds, getFillColor());
            graphics.setBackgroundPattern(gradient);
        }
        
        graphics.fillPolygon(points);
        
        if(gradient != null) {
            gradient.dispose();
        }

        // Line
        graphics.setForegroundColor(getLineColor());
        graphics.drawPolygon(points);
        
        graphics.popState();
    }

}
