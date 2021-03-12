package com.espol.controller.alerts;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class Alerts {
	
	private static Alert alerta;
	
	public static void alertaInformacion(String mensaje){
		alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.show();
	}
	
	public static void alertaError(String mensaje){
		alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.show();
	}
	
	public static String alertaConfirmacion(String mensaje){
		alerta = new Alert(Alert.AlertType.CONFIRMATION);
	    alerta.setContentText(mensaje);
	    Optional<ButtonType> result = alerta.showAndWait();
	    return result.get().getText();
	}
}
