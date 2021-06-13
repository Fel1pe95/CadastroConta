package gui;

import gui.util.Alerts;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Dao.InstanciaDao;
import model.Dao.impl.Acess;
import model.entidades.Cliente;

public class ViewConsultaController {
	@FXML
	private TextField agencia;
	@FXML
	private TextField conta;
	@FXML
	private TextField senha;
	@FXML
	private Button consultar;
	@FXML
	private Button cancelar;
	@FXML
	private Label nome;
	@FXML
	private Label cpf;
	@FXML
	private Label saldo;
	
	@FXML
	public void onConsultarAction() {
		Cliente c = new Cliente();
		Acess acess = InstanciaDao.instanciaCliente();
		acess.LeituraCliente(c.getAgencia());
		Integer ag = Integer.parseInt(agencia.getText().toString());
		Integer ct = Integer.parseInt(conta.getText().toString());
		Integer sn = Integer.parseInt(senha.getText().toString());
		boolean ver = c.verificacao(sn, ag, ct);
		if(ver == true) {
			nome.setText(c.getAgencia().get(sn).getNome());
			cpf.setText(String.format("%d", c.getAgencia().get(sn).getCpf()));
			saldo.setText(String.format("%.2f", c.getAgencia().get(sn).getConta().getSaldo()));
		}else {
			Alerts.showAlert("Dados não encontrados!", null, "Cliente nao cadastrado!", AlertType.INFORMATION);
		}
		
		
	}
	@FXML
	public void onCancelarAction(ActionEvent event) {
		Stage parentStage = Utils.currentStage(event);
		parentStage.close();
	}

}
