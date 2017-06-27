package com.archimatetool.editor.diagram.figures.factory.elements;

import org.eclipse.draw2d.IFigure;

import com.archimatetool.editor.diagram.figures.elements.FunctionFigure;
import com.archimatetool.editor.diagram.figures.factory.AbstractFigureDelegateProvider;


public class FunctionFigureDelegateProvider extends AbstractFigureDelegateProvider {

	@Override
	public Class<? extends IFigure> providerFor() {
		return FunctionFigure.class;
	}

}
