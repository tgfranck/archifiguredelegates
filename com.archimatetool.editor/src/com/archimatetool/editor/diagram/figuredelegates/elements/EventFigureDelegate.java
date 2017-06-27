package com.archimatetool.editor.diagram.figuredelegates.elements;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.graphics.Pattern;

import com.archimatetool.editor.diagram.figures.AbstractFigureDelegate;
import com.archimatetool.editor.diagram.figures.FigureUtils;
import com.archimatetool.editor.diagram.figures.IDiagramModelObjectFigure;
import com.archimatetool.editor.preferences.IPreferenceConstants;
import com.archimatetool.editor.preferences.Preferences;

public class EventFigureDelegate extends AbstractFigureDelegate {

	public EventFigureDelegate(IDiagramModelObjectFigure owner) {
		super(owner);
	}
	
	public void drawFigure(Graphics graphics){
	 	graphics.pushState();
        
        Rectangle bounds = getBounds().getCopy();
        
        int indent = Math.min(bounds.height / 3, bounds.width / 3);
        int centre_y = bounds.y + bounds.height / 2 - 1;
        int arc_startx = bounds.x + bounds.width - indent;
        
        if(!isEnabled()) {
            setDisabledState(graphics);
        }
        
        int x_offset = 2;
        int y_offset = 1;
        
        // Main Fill
        Path path = new Path(null);
        path.moveTo(bounds.x, bounds.y);
        path.lineTo(bounds.x + indent, centre_y);
        path.lineTo(bounds.x, bounds.y + bounds.height - y_offset);
        path.lineTo(arc_startx, bounds.y + bounds.height - y_offset);
        path.addArc(arc_startx - indent - x_offset, bounds.y,
                indent * 2 + 1, bounds.height - y_offset, -90, 180);
        
        graphics.setBackgroundColor(getFillColor());

        Pattern gradient = null;
        if(Preferences.STORE.getBoolean(IPreferenceConstants.SHOW_GRADIENT)) {
            gradient = FigureUtils.createGradient(graphics, bounds, getFillColor());
            graphics.setBackgroundPattern(gradient);
        }

        graphics.fillPath(path);
        
        if(gradient != null) {
            gradient.dispose();
        }

        // Outline
        graphics.setForegroundColor(getLineColor());
        path.lineTo(bounds.x, bounds.y);
        graphics.drawPath(path);
        path.dispose();
        
        graphics.popState();
	}

}
