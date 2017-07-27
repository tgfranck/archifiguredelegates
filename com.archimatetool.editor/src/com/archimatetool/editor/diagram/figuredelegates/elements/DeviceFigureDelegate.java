package com.archimatetool.editor.diagram.figuredelegates.elements;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Pattern;

import com.archimatetool.editor.diagram.figures.FigureUtils;
import com.archimatetool.editor.diagram.figures.IDiagramModelObjectFigure;
import com.archimatetool.editor.preferences.IPreferenceConstants;
import com.archimatetool.editor.preferences.Preferences;
import com.archimatetool.editor.ui.ColorFactory;

public class DeviceFigureDelegate extends AbstractPolygonalFigureDelegate{
	
    protected static final int INDENT = 15;

	public DeviceFigureDelegate(IDiagramModelObjectFigure owner) {
		super(owner);
	}
	
	@Override
	public void drawFigure(Graphics graphics){
		graphics.pushState();
        
        Rectangle bounds = getBounds().getCopy();
        
        int height_indent = bounds.height / 6;
        
        if(!isEnabled()) {
            setDisabledState(graphics);
        }
        
        // Bottom part
        PointList points1 = new PointList();
        points1.addPoint(bounds.x, bounds.y + bounds.height - 1);
        points1.addPoint(bounds.x + INDENT , bounds.y + bounds.height - height_indent - 1);
        points1.addPoint(bounds.x + bounds.width - INDENT, bounds.y + bounds.height - height_indent - 1);
        points1.addPoint(bounds.x + bounds.width, bounds.y + bounds.height - 1);
                
        graphics.setBackgroundColor(ColorFactory.getDarkerColor(getFillColor()));
        graphics.fillPolygon(points1);
        
        graphics.setForegroundColor(getLineColor());
        graphics.drawLine(bounds.x, bounds.y + bounds.height - 1,
                bounds.x + bounds.width, bounds.y + bounds.height - 1);
        graphics.drawLine(bounds.x, bounds.y + bounds.height - 1,
                bounds.x + INDENT, bounds.y + bounds.height - height_indent - 1);
        graphics.drawLine(bounds.x + bounds.width, bounds.y + bounds.height - 1,
                bounds.x + bounds.width - INDENT, bounds.y + bounds.height - height_indent - 1);

        // Top part
        Rectangle rect = new Rectangle(bounds.x, bounds.y, bounds.width, bounds.height - height_indent);

        graphics.setBackgroundColor(getFillColor());

        Pattern gradient = null;
        if(Preferences.STORE.getBoolean(IPreferenceConstants.SHOW_GRADIENT)) {
            gradient = FigureUtils.createGradient(graphics, bounds, getFillColor());
            graphics.setBackgroundPattern(gradient);
        }
        
        graphics.fillRoundRectangle(rect, 30, 30);
        
        if(gradient != null) {
            gradient.dispose();
        }

        graphics.setForegroundColor(getLineColor());
        rect = new Rectangle(bounds.x, bounds.y, bounds.width - 1, bounds.height - height_indent - 1);
        graphics.drawRoundRectangle(rect, 30, 30);
        
        graphics.popState();
	}

	@Override
	public void drawShape(Graphics graphics) {
		graphics.pushState();
        
        Rectangle bounds = getBounds().getCopy();
        
        int height_indent = bounds.height / 6;	
        
     // Bottom part
        PointList points1 = getPoints();
                
        graphics.fillPolygon(points1);
        
        graphics.drawLine(bounds.x, bounds.y + bounds.height - 1,
                bounds.x + bounds.width, bounds.y + bounds.height - 1);
        graphics.drawLine(bounds.x, bounds.y + bounds.height - 1,
                bounds.x + INDENT, bounds.y + bounds.height - height_indent - 1);
        graphics.drawLine(bounds.x + bounds.width, bounds.y + bounds.height - 1,
                bounds.x + bounds.width - INDENT, bounds.y + bounds.height - height_indent - 1);

        // Top part
        Rectangle rect = new Rectangle(bounds.x, bounds.y, bounds.width, bounds.height - height_indent);
        
        graphics.fillRoundRectangle(rect, 30, 30);
        
        rect = new Rectangle(bounds.x, bounds.y, bounds.width - 1, bounds.height - height_indent - 1);
        graphics.drawRoundRectangle(rect, 30, 30);
        
        graphics.popState();
        
        
	}

	@Override
	public PointList getPoints() {
		Rectangle bounds = getBounds().getCopy();
		int height_indent = bounds.height / 6;
		PointList points = new PointList();
        points.addPoint(bounds.x, bounds.y + bounds.height - 1);
        points.addPoint(bounds.x + INDENT , bounds.y + bounds.height - height_indent - 1);
        points.addPoint(bounds.x + bounds.width - INDENT, bounds.y + bounds.height - height_indent - 1);
        points.addPoint(bounds.x + bounds.width, bounds.y + bounds.height - 1);
        return points;
	}

}
