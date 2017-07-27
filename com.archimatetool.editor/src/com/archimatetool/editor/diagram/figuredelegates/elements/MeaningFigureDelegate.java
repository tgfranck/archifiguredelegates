package com.archimatetool.editor.diagram.figuredelegates.elements;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Pattern;

import com.archimatetool.editor.diagram.figuredelegates.AbstractFigureDelegate;
import com.archimatetool.editor.diagram.figures.FigureUtils;
import com.archimatetool.editor.diagram.figures.IDiagramModelObjectFigure;
import com.archimatetool.editor.preferences.IPreferenceConstants;
import com.archimatetool.editor.preferences.Preferences;

public class MeaningFigureDelegate extends AbstractFigureDelegate {

	public MeaningFigureDelegate(IDiagramModelObjectFigure owner) {
		super(owner);
	}
	
	public void drawFigure(Graphics graphics){
		graphics.pushState();
        
        Rectangle bounds = getBounds().getCopy();
        
        // The following is the most awful code to draw a cloud...
        
        if(!isEnabled()) {
            setDisabledState(graphics);
        }
        
        // Main fill
        graphics.setBackgroundColor(getFillColor());
        
        Pattern gradient = null;
        if(Preferences.STORE.getBoolean(IPreferenceConstants.SHOW_GRADIENT)) {
            gradient = FigureUtils.createGradient(graphics, bounds, getFillColor());
            graphics.setBackgroundPattern(gradient);
        }

        graphics.fillOval(bounds.x, bounds.y, bounds.width/3 * 2, bounds.height/3 * 2);
        graphics.fillOval(bounds.x + bounds.width/3 - 1, bounds.y, bounds.width/3 * 2, bounds.height/3 * 2);
        graphics.fillOval(bounds.x, bounds.y + bounds.height/3, bounds.width/5 * 3, bounds.height/3 * 2);
        graphics.fillOval(bounds.x + bounds.width/3, bounds.y + bounds.height/4, bounds.width/5 * 3, bounds.height/3 * 2);
        
        if(gradient != null) {
            gradient.dispose();
        }
        
        // Outline
        graphics.setForegroundColor(getLineColor());
        graphics.drawArc(bounds.x, bounds.y, bounds.width/3 * 2, bounds.height/3 * 2, 60, 147);
        graphics.drawArc(bounds.x + bounds.width/3 - 1, bounds.y, bounds.width/3 * 2 - 1, bounds.height/3 * 2, -40, 159);
        graphics.drawArc(bounds.x, bounds.y + bounds.height / 3, bounds.width/5 * 3 - 1, bounds.height/3 * 2 - 1, -43, -167);
        graphics.drawArc(bounds.x + bounds.width/3, bounds.y + bounds.height/4, bounds.width/5 * 3 - 1, bounds.height/3 * 2 - 1, 0, -110);
        
        graphics.popState();
	}

	@Override
	public void drawShape(Graphics graphics) {
		graphics.pushState();
        
        Rectangle bounds = getBounds().getCopy();
        
        // The following is the most awful code to draw a cloud...		
        
        graphics.fillOval(bounds.x, bounds.y, bounds.width/3 * 2, bounds.height/3 * 2);
        graphics.fillOval(bounds.x + bounds.width/3 - 1, bounds.y, bounds.width/3 * 2, bounds.height/3 * 2);
        graphics.fillOval(bounds.x, bounds.y + bounds.height/3, bounds.width/5 * 3, bounds.height/3 * 2);
        graphics.fillOval(bounds.x + bounds.width/3, bounds.y + bounds.height/4, bounds.width/5 * 3, bounds.height/3 * 2);
        
        // Outline
        graphics.setForegroundColor(getLineColor());
        graphics.drawArc(bounds.x, bounds.y, bounds.width/3 * 2, bounds.height/3 * 2, 60, 147);
        graphics.drawArc(bounds.x + bounds.width/3 - 1, bounds.y, bounds.width/3 * 2 - 1, bounds.height/3 * 2, -40, 159);
        graphics.drawArc(bounds.x, bounds.y + bounds.height / 3, bounds.width/5 * 3 - 1, bounds.height/3 * 2 - 1, -43, -167);
        graphics.drawArc(bounds.x + bounds.width/3, bounds.y + bounds.height/4, bounds.width/5 * 3 - 1, bounds.height/3 * 2 - 1, 0, -110);
        
        graphics.popState();
	}

}
