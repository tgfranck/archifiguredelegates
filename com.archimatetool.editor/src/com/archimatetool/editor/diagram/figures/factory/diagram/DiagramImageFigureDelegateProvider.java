package com.archimatetool.editor.diagram.figures.factory.diagram;

import org.eclipse.draw2d.IFigure;

import com.archimatetool.editor.diagram.figures.diagram.DiagramImageFigure;
import com.archimatetool.editor.diagram.figures.factory.AbstractFigureDelegateProvider;

public class DiagramImageFigureDelegateProvider extends AbstractFigureDelegateProvider {

	@Override
	public Class<? extends IFigure> providerFor() {
		return DiagramImageFigure.class;
	}

}
