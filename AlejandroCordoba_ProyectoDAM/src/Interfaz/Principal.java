package Interfaz;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import org.hibernate.NonUniqueResultException;
import org.hibernate.Session;

import Hibernate.HibernateUtil;
import ReportView.ReportView;
import ClasesBean.Alumnos;
import ClasesBean.Faltas;
import ClasesBean.FaltasId;
import ClasesBean.Modulos;
import clasesDAO.AlumnosDAO;
import clasesDAO.FaltasDAO;
import clasesDAO.ModulosDAO;

/**
 * 
 * @author Alejandro Córdoba Muñoz
 *
 **/

public class Principal extends JFrame {
	

	/**
	 * Declaración de variables usadas en la aplicación
	 */
	
	private static final long serialVersionUID = 1L;
	private JPanel panelPrincipal;
	private JButton btnGestionarMdulosProfesiones;
	private JButton btnGestionarFaltasDe;
	private JButton btnGestionarAlumnos;
	private JButton pantallaAlumnos_btnVolver;
	private JPanel pantallaModulos;
	private JPanel pantallaFaltas;
	private JButton pantallaModulos_btnVolver;
	private JButton pantallaFaltas_btnVolver;
	private JButton pantallaAlumnos_btnAlta;
	private JButton pantallaAlumnos_btnBaja;
	private JButton pantallaAlumnos_btnModificacin;
	private JButton pantallaFaltas_btnRegistro;
	private JButton pantallaFaltas_btnModificacin;
	private JButton pantallaFaltas_btnConsulta;
	private JButton pantallaFaltas_btnImprimir;
	private JPanel pantallaAlumnos_Alta;
	private JButton pantallaAlumnos_Alta_btnVolver;
	private JLabel pantallaAlumnos_Alta_lblNombre;
	private JLabel pantallaAlumnos_Alta_lblApellidos;
	private JLabel pantallaAlumnos_Alta_lblCurso;
	private JLabel pantallaAlumnos_Alta_lblDarDeAlta;
	private JButton pantallaModulos_btnAlta;
	private JButton pantallaModulos_btnBaja;
	private JButton pantallaModulos_btnAlumnos;
	private JPanel pantallaAlumnos_Modificar;
	private JButton pantallaAlumnos_Modificar_btnVolver;
	private JPanel pantallaAlumnos_Baja;
	private JButton pantallaAlumnos_Baja_btnVolver;
	private JLabel pantallaAlumnos_Baja_lblDarDeBaja;
	private JLabel pantallaAlumnos_Modificar_lblModificarDatosAlumno;
	private JButton pantallaModulos_GestionarAlumnado_btnVolver;
	private JLabel lblGestionarAlumnadoMdulo;
	private JPanel pantallaModulos_Alta;
	private JPanel pantallaModulos_Baja;
	private JButton pantallaModulos_Baja_btnVolver;
	private JButton pantallaModulos_Alta_btnVolver;
	private JLabel pantallaModulos_Alta_lblDarDeAlta;
	private JLabel pantallaModulos_Baja_lblDarDeBaja;
	private JButton pantallaModulos_GestionarAlumnado_btnMatricular;
	private JButton pantallaModulos_GestionarAlumnado_btnDesmatricular;
	private JPanel pantallaModulos_GestionarAlumnado_Matricular;
	private JPanel pantallaModulos_GestionarAlumnado_Desmatricular;
	private JLabel pantallaModulos_GestionarAlumnado_Matricular_lblMatricularAlumnadoEn;
	private JButton pantallaModulos_GestionarAlumnado_Matricular_btnVolver;
	private JLabel pantallaModulos_GestionarAlumnado_Desmatricular_lblDesmatricularAlumnadoEn;
	private JButton pantallaModulos_GestionarAlumnado_Desmatricular_btnVolver;
	private JPanel pantallaFaltas_Registrar;
	private JPanel pantallasFaltas_Modificar;
	private JButton pantallasFaltas_Modificar_btnVolver;
	private JLabel pantallasFaltas_Modificar_lblModificarFaltasDe;
	private JButton pantallaFaltas_Registrar_btnVolver;
	private JLabel pantallaFaltas_Registrar_lblRegistrarFaltasDe;
	private JPanel pantallaFaltas_Consultar;
	private JButton pantallaFaltas_Consultar_btnVolver;
	private JLabel pantallaFaltas_Consultar_lblConsultarFaltasDe;
	private JPanel pantallaFaltas_Imprimir;
	private JLabel pantallaFaltas_Imprimir_lblImprimirFaltasDe;
	private JButton pantallaFaltas_Imprimir_btnVolver;
	private JButton pantallaFaltas_Imprimir_btnImprimir;
	private JLabel pantallaAlumnos_Alta_lblIdentificador;
	private JTextField pantallaAlumnos_Alta_textFieldIdentificador;
	private JTextField pantallaAlumnos_Alta_textFieldNombre;
	private JTextField pantallaAlumnos_Alta_textFieldApellidos;
	private JTextField pantallaModulos_Alta_textFieldIdentificador;
	private JTextField pantallaModulos_Alta_textFieldNombre;
	private JTextField pantallaModulos_Alta_textFieldSiglas;
	private JTextField pantallaModulos_Alta_textFieldHoras;
	private JTextField pantallaModulos_Alta_textFieldPorcentaje;
	private JButton pantallaModulos_Alta_btnConfirmar;
	private JComboBox pantallaModulos_Alta_comboBoxCurso;
	private JMenuBar menuPrincipal;
	private JMenuItem mntmAyuda;
	private JMenuItem mntmSalir;
	private static Session session;
	private AlumnosDAO alumnosDAO = new AlumnosDAO();
	private JButton pantallaModulos_Alta_btnLimpiarCampo;
	private ModulosDAO modulosDAO = new ModulosDAO();
	private FaltasDAO faltasDAO = new FaltasDAO();
	private JTextField pantallaAlumnos_Modificar_textFieldBuscarId;
	private JTextField pantallaAlumnos_Modificar_textFieldId;
	private JTextField pantallaAlumnos_Modificar_textFieldNombre;
	private JTextField pantallaAlumnos_Modificar_textFieldApellidos;
	private JButton pantallaAlumnos_Modificar_btnLimpiarCampos;
	private JButton pantallaAlumnos_Modificar_btnBuscar;
	private JButton pantallaAlumnos_Modificar_btnConfirmar;
	private JComboBox pantallaAlumnos_Modificar_comboBoxCurso;
	private JLabel pantallaFaltas_Registrar_lblIdentificadorAlumnos;
	private JLabel pantallaFaltas_Registrar_lblIdentificadorMdulos;
	private JLabel pantallaFaltas_Registrar_lblNDeHoras;
	private JButton pantallaModulos_GestionarAlumnado_Matricular_btnConfirmar;
	private JButton pantallaModulos_GestionarAlumnado_Matricular_btnLimpiarCampo;
	private JLabel pantallaModulos_GestionarAlumnado_Matricular_lblIdentificadorAlumno;
	private JLabel pantallaModulos_GestionarAlumnado_Matricular_lblIdentificadorMdulo;
	private JTextField pantallaModulos_GestionarAlumnado_Matricular_textFieldIdAlumno;
	private JTextField pantallaModulos_GestionarAlumnado_Matricular_textFieldIdModulo;
	private JLabel pantallaModulos_lblDarDeAlta;
	private JLabel pantallaModulos_lblDarDeBaja;
	private JLabel pantallaModulos_lblMatricularODesmatricular;
	private JLabel pantallaAlumnos_lblDarDeAlta;
	private JLabel pantallaAlumnos_lblDarDeBaja;
	private JLabel pantallaAlumnos_lblModificarDatosDe;
	private JComboBox pantallaAlumnos_Baja_comboBoxId;
	private JLabel pantallaAlumnos_Baja_lblSelecionarAlumno;
	private JButton pantallaAlumnos_Baja_btnConfirmar;
	private JComboBox pantallaModulos_Baja_comboBoxIdModulos;
	private JLabel pantallaModulos_Baja_lblIndicarMdulosProfesionales;
	private JLabel pantallaModulos_Baja_lblInfo;
	private JLabel pantallaAlumnos_Baja_lblInfo;
	private JButton pantallaModulos_Baja_btnConfirmar;
	private JLabel pantallaModulos_GestionarAlumnado_Matricular_lblCursoAlumno;
	private JLabel pantallaModulos_GestionarAlumnado_Matricular_lblCursoModulo;
	private JButton pantallaModulos_GestionarAlumnado_Desmatricular_btnConfirmar;
	private JLabel pantallaModulos_GestionarAlumnado_Desmatricular_lblIdentificadorAlumno;
	private JComboBox pantallaModulos_GestionarAlumnado_Desmatricular_comboBoxIdAlumno;
	private JComboBox pantallaModulos_GestionarAlumnado_Desmatricular_comboBoxIdModulo;
	private JLabel pantallaModulos_GestionarAlumnado_Desmatricular_lblAlumno;
	private JLabel pantallaModulos_GestionarAlumnado_Desmatricular_lblModulo;
	private JLabel pantallasFaltas_Modificar_lblIdentificadorMdulo;
	private JComboBox pantallasFaltas_Modificar_comboBoxIdModulo;
	private JLabel pantallasFaltas_Modificar_lblModulo;
	private JButton pantallasFaltas_Modificar_btnConfirmar;
	private JLabel pantallasFaltas_Modificar_lblIdentificadorAlumnos;
	private JComboBox pantallasFaltas_Modificar_comboBoxIdAlumno;
	private JLabel pantallasFaltas_Modificar_lblIdAlumno;
	private JLabel pantallasFaltas_Modificar_lblNHoras;
	private JTextField pantallasFaltas_Modificar_textFieldHoras;
	private JComboBox pantallaFaltas_Registrar_comboBoxIdAlumno;
	private JComboBox pantallaFaltas_Registrar_comboBoxIdModulo;
	private JLabel pantallaFaltas_Registrar_lblModulo;
	private JLabel pantallaFaltas_Registrar_lblAlumno;
	private JComboBox pantallaFaltas_Consultar_comboBoxModulo;
	private JLabel pantallaFaltas_Consultar_lblInfoModulo;
	private JComboBox pantallaFaltas_Consultar_comboBoxAlumnos;
	private JComboBox pantallaFaltas_Imprimir_comboBoxModulo;
	private JLabel lblIdentificadorMdulo;
	private JLabel pantallaFaltas_Imprimir_lblModulo;
	private JLabel pantallaFaltas_Consultar_lblAlumno;

	/**
	 * Lanzamos la aplicación.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Creamos el frame.
	 */
	
	public Principal() {
		
		session = HibernateUtil.getSession();
		
		setTitle("Registro de Asistencia 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 400);
		
		menuPrincipal = new JMenuBar();
		menuPrincipal.setFont(new Font("Times New Roman", Font.BOLD, 12));
		menuPrincipal.setBackground(Color.CYAN);
		setJMenuBar(menuPrincipal);
		
		mntmAyuda = new JMenuItem("Ayuda");
		mntmAyuda.setFont(new Font("Times New Roman", Font.BOLD, 12));
		menuPrincipal.add(mntmAyuda);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object [] texto={"Si","No"};
				int opcion= JOptionPane.showOptionDialog (panelPrincipal,"¿Desea salir de la aplicación ahora?", "Mensaje de confirmación", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,null, texto, texto[0]);
				if(opcion==0){
					System.exit(0);
				}
			}
		});
		mntmSalir.setFont(new Font("Times New Roman", Font.BOLD, 12));
		menuPrincipal.add(mntmSalir);
		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(Color.MAGENTA);
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(new CardLayout(0, 0));
		
		JPanel primeraPantalla = new JPanel();
		primeraPantalla.setBackground(Color.CYAN);
		panelPrincipal.add(primeraPantalla, "name_18551895859389");
		
		btnGestionarAlumnos = new JButton("Gestionar Alumnos");
		btnGestionarAlumnos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout l =(CardLayout)panelPrincipal.getLayout();
				l.show(panelPrincipal,"name_19970894796126");
			}
		});
		btnGestionarAlumnos.setIcon(new ImageIcon(Principal.class.getResource("/Res/alumnado.png")));
		btnGestionarAlumnos.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		btnGestionarMdulosProfesiones = new JButton("Gestionar M\u00F3dulos Profesiones");
		btnGestionarMdulosProfesiones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout l =(CardLayout)panelPrincipal.getLayout();
				l.show(panelPrincipal,"name_20472107377334");
			}
		});
		btnGestionarMdulosProfesiones.setIcon(new ImageIcon(Principal.class.getResource("/Res/profesionalesModulos.gif")));
		btnGestionarMdulosProfesiones.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		btnGestionarFaltasDe = new JButton("Gestionar Faltas de Asistencia");
		btnGestionarFaltasDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout l =(CardLayout)panelPrincipal.getLayout();
				l.show(panelPrincipal,"name_20532684802118");
			}
		});
		btnGestionarFaltasDe.setIcon(new ImageIcon(Principal.class.getResource("/Res/asistenciaFalta.gif")));
		btnGestionarFaltasDe.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object [] texto={"Si","No"};
				int opcion= JOptionPane.showOptionDialog (panelPrincipal,"¿Desea salir de la aplicación ahora?", "Mensaje de confirmación", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,null, texto, texto[0]);
				if(opcion==0){
					System.exit(0);
				}
			}
		});
		btnSalir.setIcon(new ImageIcon(Principal.class.getResource("/Res/saliRrR.png")));
		btnSalir.setFont(new Font("Times New Roman", Font.BOLD, 12));
		GroupLayout gl_primeraPantalla = new GroupLayout(primeraPantalla);
		gl_primeraPantalla.setHorizontalGroup(
			gl_primeraPantalla.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_primeraPantalla.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_primeraPantalla.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnGestionarFaltasDe, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnGestionarAlumnos, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
					.addGroup(gl_primeraPantalla.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnSalir, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnGestionarMdulosProfesiones, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_primeraPantalla.setVerticalGroup(
			gl_primeraPantalla.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_primeraPantalla.createSequentialGroup()
					.addGap(42)
					.addGroup(gl_primeraPantalla.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnGestionarMdulosProfesiones, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
						.addComponent(btnGestionarAlumnos, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
					.addGap(57)
					.addGroup(gl_primeraPantalla.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnGestionarFaltasDe, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		primeraPantalla.setLayout(gl_primeraPantalla);
		
		pantallaFaltas = new JPanel();
		pantallaFaltas.setBackground(Color.CYAN);
		panelPrincipal.add(pantallaFaltas, "name_20532684802118");
		
		pantallaFaltas_btnVolver = new JButton("Volver");
		pantallaFaltas_btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout l =(CardLayout)panelPrincipal.getLayout();
				l.show(panelPrincipal,"name_18551895859389");
			}
		});
		pantallaFaltas_btnVolver.setIcon(new ImageIcon(Principal.class.getResource("/Res/icono-volver.png")));
		pantallaFaltas_btnVolver.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		pantallaFaltas_btnRegistro = new JButton("Registrar");
		pantallaFaltas_btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout l =(CardLayout)panelPrincipal.getLayout();
				l.show(panelPrincipal,"name_62726812460801");
				List <Modulos> modulos = new ArrayList<Modulos>();
				modulos = modulosDAO.listarTodos();
				if(modulos != null){
					for(Modulos m : modulos){
						if(m != null){
							pantallaFaltas_Registrar_comboBoxIdModulo.addItem(m.getId_Modulo());
						}
					}
				}
			}
		});
		pantallaFaltas_btnRegistro.setIcon(new ImageIcon(Principal.class.getResource("/Res/icono_registrar.png")));
		pantallaFaltas_btnRegistro.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		pantallaFaltas_btnModificacin = new JButton("Modificar");
		pantallaFaltas_btnModificacin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout l =(CardLayout)panelPrincipal.getLayout();
				l.show(panelPrincipal,"name_62782197594107");
				List <Faltas> faltas = new ArrayList<Faltas>();
				faltas = faltasDAO.listarTodos();
				if(faltas != null){
					for(Faltas f : faltas){
						if(f != null){
							FaltasId faltasID = new FaltasId ();
							faltasID = f.getId();
							pantallasFaltas_Modificar_comboBoxIdModulo.addItem(faltasID.getId_Modulo());
						}
					}
				}
				}
		});
		pantallaFaltas_btnModificacin.setIcon(new ImageIcon(Principal.class.getResource("/Res/modificacion.gif")));
		pantallaFaltas_btnModificacin.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		pantallaFaltas_btnConsulta = new JButton("Consultar");
		pantallaFaltas_btnConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout l =(CardLayout)panelPrincipal.getLayout();
				l.show(panelPrincipal,"name_63804416726148");
				List <Modulos> modulos = new ArrayList<Modulos>();
				modulos = modulosDAO.listarTodos();
				if(modulos != null){
					for(Modulos m : modulos){
						if(m != null){
							pantallaFaltas_Consultar_comboBoxModulo.addItem(m.getId_Modulo());
						}
					}
				}
			}
		});
		pantallaFaltas_btnConsulta.setIcon(new ImageIcon(Principal.class.getResource("/Res/icono_consultar.gif")));
		pantallaFaltas_btnConsulta.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		pantallaFaltas_btnImprimir = new JButton("Imprimir");
		pantallaFaltas_btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout l =(CardLayout)panelPrincipal.getLayout();
				l.show(panelPrincipal,"name_64202045247091");
				List <Modulos> modulos = new ArrayList <Modulos>();
				modulos = modulosDAO.listarTodos();
				if(modulos != null){
					for(Modulos m : modulos){
						if(m != null){
							pantallaFaltas_Imprimir_comboBoxModulo.addItem(m.getId_Modulo());
						}
					}
				}
			}
		});
		pantallaFaltas_btnImprimir.setIcon(new ImageIcon(Principal.class.getResource("/Res/icono_imprimir.png")));
		pantallaFaltas_btnImprimir.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JLabel pantallaFaltas_label = new JLabel("Gestionar Faltas de Asistencia");
		pantallaFaltas_label.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JLabel pantallaFaltas_lblRegistrarFaltasDe = new JLabel("Registrar Faltas de Asistencia.");
		pantallaFaltas_lblRegistrarFaltasDe.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JLabel pantallaFaltas_lblModificarFaltasDe = new JLabel("Modificar Faltas de Asistencia.");
		pantallaFaltas_lblModificarFaltasDe.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JLabel pantallaFaltas_lblConsultarFaltasDe = new JLabel("Consultar Faltas de Asistencia.");
		pantallaFaltas_lblConsultarFaltasDe.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JLabel pantallaFaltas_lblImprimirFaltasDe = new JLabel("Imprimir Faltas de Asistencia.");
		pantallaFaltas_lblImprimirFaltasDe.setFont(new Font("Times New Roman", Font.BOLD, 12));
		GroupLayout gl_pantallaFaltas = new GroupLayout(pantallaFaltas);
		gl_pantallaFaltas.setHorizontalGroup(
			gl_pantallaFaltas.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pantallaFaltas.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pantallaFaltas.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_pantallaFaltas.createSequentialGroup()
							.addGroup(gl_pantallaFaltas.createParallelGroup(Alignment.TRAILING)
								.addComponent(pantallaFaltas_btnRegistro, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
								.addComponent(pantallaFaltas_btnVolver, Alignment.LEADING)
								.addComponent(pantallaFaltas_btnModificacin, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
							.addGroup(gl_pantallaFaltas.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pantallaFaltas.createSequentialGroup()
									.addGap(122)
									.addComponent(pantallaFaltas_label))
								.addGroup(gl_pantallaFaltas.createSequentialGroup()
									.addGap(33)
									.addGroup(gl_pantallaFaltas.createParallelGroup(Alignment.LEADING)
										.addComponent(pantallaFaltas_lblModificarFaltasDe)
										.addComponent(pantallaFaltas_lblRegistrarFaltasDe)
										.addComponent(pantallaFaltas_lblConsultarFaltasDe)
										.addComponent(pantallaFaltas_lblImprimirFaltasDe))))
							.addGap(29))
						.addGroup(gl_pantallaFaltas.createSequentialGroup()
							.addComponent(pantallaFaltas_btnConsulta, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
							.addGap(337))
						.addGroup(gl_pantallaFaltas.createSequentialGroup()
							.addComponent(pantallaFaltas_btnImprimir, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
							.addGap(337))))
		);
		gl_pantallaFaltas.setVerticalGroup(
			gl_pantallaFaltas.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pantallaFaltas.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pantallaFaltas.createParallelGroup(Alignment.BASELINE)
						.addComponent(pantallaFaltas_btnVolver)
						.addComponent(pantallaFaltas_label))
					.addGap(18)
					.addGroup(gl_pantallaFaltas.createParallelGroup(Alignment.BASELINE)
						.addComponent(pantallaFaltas_btnRegistro)
						.addComponent(pantallaFaltas_lblRegistrarFaltasDe))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pantallaFaltas.createParallelGroup(Alignment.BASELINE)
						.addComponent(pantallaFaltas_btnModificacin)
						.addComponent(pantallaFaltas_lblModificarFaltasDe))
					.addGap(11)
					.addGroup(gl_pantallaFaltas.createParallelGroup(Alignment.BASELINE)
						.addComponent(pantallaFaltas_btnConsulta)
						.addComponent(pantallaFaltas_lblConsultarFaltasDe))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pantallaFaltas.createParallelGroup(Alignment.BASELINE)
						.addComponent(pantallaFaltas_btnImprimir)
						.addComponent(pantallaFaltas_lblImprimirFaltasDe))
					.addGap(16))
		);
		pantallaFaltas.setLayout(gl_pantallaFaltas);
		
		pantallaModulos = new JPanel();
		pantallaModulos.setBackground(Color.CYAN);
		panelPrincipal.add(pantallaModulos, "name_20472107377334");
		
		pantallaModulos_btnVolver = new JButton("Volver");
		pantallaModulos_btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout l =(CardLayout)panelPrincipal.getLayout();
				l.show(panelPrincipal,"name_18551895859389");
			}
		});
		pantallaModulos_btnVolver.setIcon(new ImageIcon(Principal.class.getResource("/Res/icono-volver.png")));
		pantallaModulos_btnVolver.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JLabel lblGestionarMdulosProfesionales = new JLabel("Gestionar M\u00F3dulos Profesionales");
		lblGestionarMdulosProfesionales.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		pantallaModulos_btnAlta = new JButton("Dar de Alta");
		pantallaModulos_btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout l =(CardLayout)panelPrincipal.getLayout();
				l.show(panelPrincipal,"name_59753157630927");
			}
		});
		pantallaModulos_btnAlta.setIcon(new ImageIcon(Principal.class.getResource("/Res/alta.png")));
		pantallaModulos_btnAlta.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		pantallaModulos_btnBaja = new JButton("Dar de Baja");
		pantallaModulos_btnBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout l =(CardLayout)panelPrincipal.getLayout();
				l.show(panelPrincipal,"name_59824787721623");
				List <Modulos> modulos = modulosDAO.listarTodos();
				if(modulos != null){
					for(Modulos m : modulos){
						if(m != null){
							pantallaModulos_Baja_comboBoxIdModulos.addItem(m.getId_Modulo());
						}
					}
				}
			}
		});
		pantallaModulos_btnBaja.setIcon(new ImageIcon(Principal.class.getResource("/Res/eliminar.png")));
		pantallaModulos_btnBaja.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		pantallaModulos_btnAlumnos = new JButton("Gestionar Alumnado");
		pantallaModulos_btnAlumnos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout l =(CardLayout)panelPrincipal.getLayout();
				l.show(panelPrincipal,"name_59369311308280");
			}
		});
		pantallaModulos_btnAlumnos.setIcon(new ImageIcon(Principal.class.getResource("/Res/alumnado.png")));
		pantallaModulos_btnAlumnos.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		pantallaModulos_lblDarDeAlta = new JLabel("Dar de Alta un M\u00F3dulo Profesional.");
		pantallaModulos_lblDarDeAlta.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		pantallaModulos_lblDarDeBaja = new JLabel("Dar de Baja un M\u00F3dulo Profesional.");
		pantallaModulos_lblDarDeBaja.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		pantallaModulos_lblMatricularODesmatricular = new JLabel("Matricular o Desmatricular.");
		pantallaModulos_lblMatricularODesmatricular.setFont(new Font("Times New Roman", Font.BOLD, 12));
		GroupLayout gl_pantallaModulos = new GroupLayout(pantallaModulos);
		gl_pantallaModulos.setHorizontalGroup(
			gl_pantallaModulos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pantallaModulos.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pantallaModulos.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pantallaModulos.createSequentialGroup()
							.addComponent(pantallaModulos_btnVolver)
							.addPreferredGap(ComponentPlacement.RELATED, 295, Short.MAX_VALUE)
							.addComponent(lblGestionarMdulosProfesionales)
							.addGap(22))
						.addGroup(gl_pantallaModulos.createSequentialGroup()
							.addGroup(gl_pantallaModulos.createParallelGroup(Alignment.TRAILING)
								.addComponent(pantallaModulos_btnAlumnos, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
								.addComponent(pantallaModulos_btnBaja, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
								.addComponent(pantallaModulos_btnAlta, GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE))
							.addGap(35)
							.addGroup(gl_pantallaModulos.createParallelGroup(Alignment.LEADING)
								.addComponent(pantallaModulos_lblDarDeAlta)
								.addComponent(pantallaModulos_lblDarDeBaja)
								.addComponent(pantallaModulos_lblMatricularODesmatricular))
							.addGap(213))))
		);
		gl_pantallaModulos.setVerticalGroup(
			gl_pantallaModulos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pantallaModulos.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pantallaModulos.createParallelGroup(Alignment.BASELINE)
						.addComponent(pantallaModulos_btnVolver)
						.addComponent(lblGestionarMdulosProfesionales))
					.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
					.addGroup(gl_pantallaModulos.createParallelGroup(Alignment.BASELINE)
						.addComponent(pantallaModulos_btnAlta, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
						.addComponent(pantallaModulos_lblDarDeAlta))
					.addGap(37)
					.addGroup(gl_pantallaModulos.createParallelGroup(Alignment.BASELINE)
						.addComponent(pantallaModulos_btnBaja)
						.addComponent(pantallaModulos_lblDarDeBaja))
					.addGap(31)
					.addGroup(gl_pantallaModulos.createParallelGroup(Alignment.BASELINE)
						.addComponent(pantallaModulos_btnAlumnos)
						.addComponent(pantallaModulos_lblMatricularODesmatricular))
					.addGap(24))
		);
		pantallaModulos.setLayout(gl_pantallaModulos);
		
		JPanel pantallaAlumnos = new JPanel();
		pantallaAlumnos.setBackground(Color.CYAN);
		panelPrincipal.add(pantallaAlumnos, "name_19970894796126");
		
		pantallaAlumnos_btnVolver = new JButton("Volver");
		pantallaAlumnos_btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout l =(CardLayout)panelPrincipal.getLayout();
				l.show(panelPrincipal,"name_18551895859389");
			}
		});
		pantallaAlumnos_btnVolver.setIcon(new ImageIcon(Principal.class.getResource("/Res/icono-volver.png")));
		pantallaAlumnos_btnVolver.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		pantallaAlumnos_btnAlta = new JButton("Dar de Alta");
		pantallaAlumnos_btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout l =(CardLayout)panelPrincipal.getLayout();
				l.show(panelPrincipal,"name_26439807682540");
			}
		});
		pantallaAlumnos_btnAlta.setIcon(new ImageIcon(Principal.class.getResource("/Res/alta.png")));
		pantallaAlumnos_btnAlta.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		pantallaAlumnos_btnBaja = new JButton("Dar de Baja");
		pantallaAlumnos_btnBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout l =(CardLayout)panelPrincipal.getLayout();
				l.show(panelPrincipal,"name_58549444208132");
				List <Alumnos> alumnos = alumnosDAO.listarTodos();
				if(alumnos != null){
					for(Alumnos a:alumnos){
						if(a!=null){
							pantallaAlumnos_Baja_comboBoxId.addItem(a.getId_Alumno());
						}
					}
				}
				}
		});
		pantallaAlumnos_btnBaja.setFont(new Font("Times New Roman", Font.BOLD, 12));
		pantallaAlumnos_btnBaja.setIcon(new ImageIcon(Principal.class.getResource("/Res/eliminar.png")));
		
		pantallaAlumnos_btnModificacin = new JButton("Modificar");
		pantallaAlumnos_btnModificacin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout l =(CardLayout)panelPrincipal.getLayout();
				l.show(panelPrincipal,"name_58188239391878");
				pantallaAlumnos_Modificar_btnConfirmar.setEnabled(false);
				pantallaAlumnos_Modificar_textFieldApellidos.setEnabled(false);
				pantallaAlumnos_Modificar_textFieldId.setEnabled(false);
				pantallaAlumnos_Modificar_textFieldNombre.setEnabled(false);
				pantallaAlumnos_Modificar_comboBoxCurso.setEnabled(false);
//				List <Modulos> modulos = modulosDAO.listarTodos();
//				if(modulos != null){
//					for(Modulos m : modulos){
//						if(m != null){
//							System.out.println(m.getId_Modulo()+" "+m.getNombre());
//							pantallaAlumnos_Modificar_comboBoxAlumnos.setModel(new DefaultComboBoxModel(new String [] {m.getId_Modulo()+" - "+m.getNombre()+" - "+m.getSiglas()}));
//							pantallaAlumnos_Modificar_comboBoxAlumnos.addItem(m.getId_Modulo()+" - "+m.getNombre()+" - "+m.getSiglas());
//				}
//			}
//		}
		}});
		pantallaAlumnos_btnModificacin.setFont(new Font("Times New Roman", Font.BOLD, 12));
		pantallaAlumnos_btnModificacin.setIcon(new ImageIcon(Principal.class.getResource("/Res/modificacion.gif")));
		
		JLabel pantallaAlumnos_label = new JLabel("Gestionar Alumnado");
		pantallaAlumnos_label.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		pantallaAlumnos_lblDarDeAlta = new JLabel("Dar de Alta a un Alumno.");
		pantallaAlumnos_lblDarDeAlta.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		pantallaAlumnos_lblDarDeBaja = new JLabel("Dar de Baja a un Alumno.");
		pantallaAlumnos_lblDarDeBaja.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		pantallaAlumnos_lblModificarDatosDe = new JLabel("Modificar Datos de un Alumno.");
		pantallaAlumnos_lblModificarDatosDe.setFont(new Font("Times New Roman", Font.BOLD, 12));
		GroupLayout gl_pantallaAlumnos = new GroupLayout(pantallaAlumnos);
		gl_pantallaAlumnos.setHorizontalGroup(
			gl_pantallaAlumnos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pantallaAlumnos.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pantallaAlumnos.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pantallaAlumnos.createParallelGroup(Alignment.LEADING)
							.addComponent(pantallaAlumnos_btnVolver)
							.addGroup(gl_pantallaAlumnos.createSequentialGroup()
								.addComponent(pantallaAlumnos_btnModificacin, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED))
							.addComponent(pantallaAlumnos_btnBaja, GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE))
						.addComponent(pantallaAlumnos_btnAlta, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_pantallaAlumnos.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pantallaAlumnos.createSequentialGroup()
							.addGap(47)
							.addGroup(gl_pantallaAlumnos.createParallelGroup(Alignment.LEADING)
								.addComponent(pantallaAlumnos_lblDarDeAlta)
								.addComponent(pantallaAlumnos_lblDarDeBaja)
								.addComponent(pantallaAlumnos_lblModificarDatosDe))
							.addGap(173))
						.addGroup(Alignment.TRAILING, gl_pantallaAlumnos.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
							.addComponent(pantallaAlumnos_label)
							.addGap(54))))
		);
		gl_pantallaAlumnos.setVerticalGroup(
			gl_pantallaAlumnos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pantallaAlumnos.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pantallaAlumnos.createParallelGroup(Alignment.BASELINE)
						.addComponent(pantallaAlumnos_btnVolver)
						.addComponent(pantallaAlumnos_label))
					.addGap(44)
					.addGroup(gl_pantallaAlumnos.createParallelGroup(Alignment.BASELINE)
						.addComponent(pantallaAlumnos_btnAlta, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
						.addComponent(pantallaAlumnos_lblDarDeAlta))
					.addGap(27)
					.addGroup(gl_pantallaAlumnos.createParallelGroup(Alignment.BASELINE)
						.addComponent(pantallaAlumnos_btnBaja)
						.addComponent(pantallaAlumnos_lblDarDeBaja))
					.addGap(30)
					.addGroup(gl_pantallaAlumnos.createParallelGroup(Alignment.BASELINE)
						.addComponent(pantallaAlumnos_btnModificacin)
						.addComponent(pantallaAlumnos_lblModificarDatosDe))
					.addContainerGap(25, Short.MAX_VALUE))
		);
		pantallaAlumnos.setLayout(gl_pantallaAlumnos);
		
		pantallaAlumnos_Alta = new JPanel();
		pantallaAlumnos_Alta.setBackground(Color.CYAN);
		panelPrincipal.add(pantallaAlumnos_Alta, "name_26439807682540");
		
		pantallaAlumnos_Alta_btnVolver = new JButton("Volver");
		pantallaAlumnos_Alta_btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout l =(CardLayout)panelPrincipal.getLayout();
				l.show(panelPrincipal,"name_19970894796126");
			}
		});
		pantallaAlumnos_Alta_btnVolver.setFont(new Font("Tahoma", Font.BOLD, 12));
		pantallaAlumnos_Alta_btnVolver.setIcon(new ImageIcon(Principal.class.getResource("/Res/icono-volver.png")));
		
		pantallaAlumnos_Alta_lblNombre = new JLabel("Nombre");
		pantallaAlumnos_Alta_lblNombre.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		pantallaAlumnos_Alta_lblApellidos = new JLabel("Apellidos");
		pantallaAlumnos_Alta_lblApellidos.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		pantallaAlumnos_Alta_lblCurso = new JLabel("Curso");
		pantallaAlumnos_Alta_lblCurso.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		pantallaAlumnos_Alta_lblDarDeAlta = new JLabel("Dar de Alta a Alumno");
		pantallaAlumnos_Alta_lblDarDeAlta.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		pantallaAlumnos_Alta_lblIdentificador = new JLabel("Identificador");
		pantallaAlumnos_Alta_lblIdentificador.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		pantallaAlumnos_Alta_textFieldIdentificador = new JTextField();
		pantallaAlumnos_Alta_textFieldIdentificador.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		pantallaAlumnos_Alta_textFieldIdentificador.setColumns(10);
		
		pantallaAlumnos_Alta_textFieldNombre = new JTextField();
		pantallaAlumnos_Alta_textFieldNombre.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		pantallaAlumnos_Alta_textFieldNombre.setColumns(10);
		
		pantallaAlumnos_Alta_textFieldApellidos = new JTextField();
		pantallaAlumnos_Alta_textFieldApellidos.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		pantallaAlumnos_Alta_textFieldApellidos.setColumns(10);
		
		final JComboBox pantallaAlumnos_Alta_comboBoxCurso = new JComboBox();
		pantallaAlumnos_Alta_comboBoxCurso.setModel(new DefaultComboBoxModel(new String[] {"1 DAM", "1 SMR", "2 DAM", "2 SMR"}));
		pantallaAlumnos_Alta_comboBoxCurso.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		JButton pantallaAlumnos_Alta_btnConfirmar = new JButton("Confirmar");
		pantallaAlumnos_Alta_btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				Alumnos alumno = new Alumnos();
				String id = pantallaAlumnos_Alta_textFieldIdentificador.getText();
				String nombre = pantallaAlumnos_Alta_textFieldNombre.getText();
				String apellidos = pantallaAlumnos_Alta_textFieldApellidos.getText();
				Object curso = pantallaAlumnos_Alta_comboBoxCurso.getSelectedItem();
				alumno.setId_Alumno(Integer.parseInt(id));
				alumno.setNombre(nombre);
				alumno.setApellido(apellidos);
				alumno.setCurso((String) curso);
				if(pantallaAlumnos_Alta_textFieldIdentificador.getText().equals("")){
					Object [] texto={"Confirmar","Cancelar"};
					JOptionPane.showOptionDialog (panelPrincipal,"Debes introducir todos los campos.", "Error entrada de datos.", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE,null, texto, texto[0]);
				}if(pantallaAlumnos_Alta_textFieldNombre.getText().equals(" ")){
					Object [] texto={"Confirmar","Cancelar"};
					JOptionPane.showOptionDialog (panelPrincipal,"Debes introducir todos los campos.", "Error entrada de datos.", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE,null, texto, texto[0]);
				}if(pantallaAlumnos_Alta_textFieldApellidos.getText().equals(" ")){
					Object [] texto={"Confirmar","Cancelar"};
					JOptionPane.showOptionDialog (panelPrincipal,"Debes introducir todos los campos.", "Error entrada de datos.", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE,null, texto, texto[0]);
				}
					session.beginTransaction();
					session.save(alumno);
					session.getTransaction().commit();
					JOptionPane.showMessageDialog(panelPrincipal, "Se ha insertado un registro en la base de datos.","Entrada de datos.",JOptionPane.INFORMATION_MESSAGE);
				
			} catch (NumberFormatException e1) {
				Object [] texto={"Confirmar","Cancelar"};
				JOptionPane.showOptionDialog (panelPrincipal,"Debes introducir todos los campos.", "Error entrada de datos.", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE,null, texto, texto[0]);
			} catch (HeadlessException e1) {
				Object [] texto={"Confirmar","Cancelar"};
				JOptionPane.showOptionDialog (panelPrincipal,"Debes introducir todos los campos.", "Error entrada de datos.", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE,null, texto, texto[0]);
			} catch (NonUniqueResultException e1){
				Object [] texto={"Confirmar","Cancelar"};
				JOptionPane.showOptionDialog (panelPrincipal,"Debes introducir otro identificador.", "Error identificador utilizado.", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE,null, texto, texto[0]);
			}
			}
		});
		pantallaAlumnos_Alta_btnConfirmar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		pantallaAlumnos_Alta_btnConfirmar.setIcon(new ImageIcon(Principal.class.getResource("/Res/alta.png")));
		
		JButton pantallaALumnos_Alta_btnLimpiarCampos = new JButton("Limpiar Campos");
		pantallaALumnos_Alta_btnLimpiarCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pantallaAlumnos_Alta_textFieldIdentificador.setText("");
				pantallaAlumnos_Alta_textFieldNombre.setText("");
				pantallaAlumnos_Alta_textFieldApellidos.setText("");
				pantallaAlumnos_Alta_comboBoxCurso.setSelectedIndex(0);
			}
		});
		pantallaALumnos_Alta_btnLimpiarCampos.setIcon(new ImageIcon(Principal.class.getResource("/Res/limpiar.gif")));
		pantallaALumnos_Alta_btnLimpiarCampos.setFont(new Font("Times New Roman", Font.BOLD, 12));
		GroupLayout gl_pantallaAlumnos_Alta = new GroupLayout(pantallaAlumnos_Alta);
		gl_pantallaAlumnos_Alta.setHorizontalGroup(
			gl_pantallaAlumnos_Alta.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pantallaAlumnos_Alta.createSequentialGroup()
					.addContainerGap()
					.addComponent(pantallaAlumnos_Alta_btnVolver)
					.addPreferredGap(ComponentPlacement.RELATED, 356, Short.MAX_VALUE)
					.addComponent(pantallaAlumnos_Alta_lblDarDeAlta)
					.addGap(23))
				.addGroup(gl_pantallaAlumnos_Alta.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_pantallaAlumnos_Alta.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pantallaAlumnos_Alta.createSequentialGroup()
							.addComponent(pantallaAlumnos_Alta_lblIdentificador)
							.addGap(37)
							.addComponent(pantallaAlumnos_Alta_textFieldIdentificador, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
						.addGroup(gl_pantallaAlumnos_Alta.createSequentialGroup()
							.addComponent(pantallaAlumnos_Alta_lblCurso)
							.addGap(72)
							.addComponent(pantallaAlumnos_Alta_comboBoxCurso, 0, 131, Short.MAX_VALUE)))
					.addGap(88)
					.addGroup(gl_pantallaAlumnos_Alta.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_pantallaAlumnos_Alta.createSequentialGroup()
							.addComponent(pantallaAlumnos_Alta_lblApellidos)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(pantallaAlumnos_Alta_textFieldApellidos, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pantallaAlumnos_Alta.createSequentialGroup()
							.addComponent(pantallaAlumnos_Alta_lblNombre)
							.addGap(62)
							.addComponent(pantallaAlumnos_Alta_textFieldNombre, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)))
					.addGap(41))
				.addGroup(gl_pantallaAlumnos_Alta.createSequentialGroup()
					.addContainerGap()
					.addComponent(pantallaALumnos_Alta_btnLimpiarCampos)
					.addGap(26)
					.addComponent(pantallaAlumnos_Alta_btnConfirmar)
					.addContainerGap())
		);
		gl_pantallaAlumnos_Alta.setVerticalGroup(
			gl_pantallaAlumnos_Alta.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pantallaAlumnos_Alta.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pantallaAlumnos_Alta.createParallelGroup(Alignment.BASELINE)
						.addComponent(pantallaAlumnos_Alta_btnVolver)
						.addComponent(pantallaAlumnos_Alta_lblDarDeAlta))
					.addGap(53)
					.addGroup(gl_pantallaAlumnos_Alta.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pantallaAlumnos_Alta.createParallelGroup(Alignment.BASELINE)
							.addComponent(pantallaAlumnos_Alta_lblNombre)
							.addComponent(pantallaAlumnos_Alta_textFieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pantallaAlumnos_Alta.createParallelGroup(Alignment.BASELINE)
							.addComponent(pantallaAlumnos_Alta_lblIdentificador)
							.addComponent(pantallaAlumnos_Alta_textFieldIdentificador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(45)
					.addGroup(gl_pantallaAlumnos_Alta.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_pantallaAlumnos_Alta.createParallelGroup(Alignment.BASELINE)
							.addComponent(pantallaAlumnos_Alta_lblApellidos)
							.addComponent(pantallaAlumnos_Alta_textFieldApellidos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(pantallaAlumnos_Alta_lblCurso)
						.addComponent(pantallaAlumnos_Alta_comboBoxCurso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
					.addGroup(gl_pantallaAlumnos_Alta.createParallelGroup(Alignment.BASELINE)
						.addComponent(pantallaAlumnos_Alta_btnConfirmar)
						.addComponent(pantallaALumnos_Alta_btnLimpiarCampos, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		pantallaAlumnos_Alta.setLayout(gl_pantallaAlumnos_Alta);
		
		pantallaAlumnos_Modificar = new JPanel();
		pantallaAlumnos_Modificar.setBackground(Color.CYAN);
		panelPrincipal.add(pantallaAlumnos_Modificar, "name_58188239391878");
		
		pantallaAlumnos_Modificar_btnVolver = new JButton("Volver");
		pantallaAlumnos_Modificar_btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout l =(CardLayout)panelPrincipal.getLayout();
				l.show(panelPrincipal,"name_19970894796126");
			}
		});
		pantallaAlumnos_Modificar_btnVolver.setIcon(new ImageIcon(Principal.class.getResource("/Res/icono-volver.png")));
		pantallaAlumnos_Modificar_btnVolver.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		pantallaAlumnos_Modificar_lblModificarDatosAlumno = new JLabel("Modificar Datos Alumno");
		pantallaAlumnos_Modificar_lblModificarDatosAlumno.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JLabel pantallaAlumnos_Modificar_lblIntroduzcaElIdentificador = new JLabel("Introduzca el Identificador del Alumno a Modificar");
		pantallaAlumnos_Modificar_lblIntroduzcaElIdentificador.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		pantallaAlumnos_Modificar_textFieldBuscarId = new JTextField();
		pantallaAlumnos_Modificar_textFieldBuscarId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		pantallaAlumnos_Modificar_textFieldBuscarId.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		pantallaAlumnos_Modificar_textFieldBuscarId.setColumns(10);
		
		JLabel pantallaAlumnos_Modificar_lblIdentificador = new JLabel("Identificador");
		pantallaAlumnos_Modificar_lblIdentificador.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JLabel pantallaAlumnos_Modificar_lblNombre = new JLabel("Nombre");
		pantallaAlumnos_Modificar_lblNombre.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JLabel pantallaAlumnos_Modificar_lblCurso = new JLabel("Curso");
		pantallaAlumnos_Modificar_lblCurso.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JLabel pantallaAlumnos_Modificar_lblApellidos = new JLabel("Apellidos");
		pantallaAlumnos_Modificar_lblApellidos.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		pantallaAlumnos_Modificar_textFieldId = new JTextField();
		pantallaAlumnos_Modificar_textFieldId.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		pantallaAlumnos_Modificar_textFieldId.setColumns(10);
		
		pantallaAlumnos_Modificar_textFieldNombre = new JTextField();
		pantallaAlumnos_Modificar_textFieldNombre.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		pantallaAlumnos_Modificar_textFieldNombre.setColumns(10);
		
		pantallaAlumnos_Modificar_textFieldApellidos = new JTextField();
		pantallaAlumnos_Modificar_textFieldApellidos.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		pantallaAlumnos_Modificar_textFieldApellidos.setColumns(10);
		
		pantallaAlumnos_Modificar_comboBoxCurso = new JComboBox();
		pantallaAlumnos_Modificar_comboBoxCurso.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		pantallaAlumnos_Modificar_comboBoxCurso.setModel(new DefaultComboBoxModel(new String[] {"1 DAM", "1 SMR", "2 DAM", "2 SMR"}));
		
		pantallaAlumnos_Modificar_btnConfirmar = new JButton("Confirmar");
		pantallaAlumnos_Modificar_btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				session.beginTransaction();
//				Alumnos a = alumnosDAO.buscarId(1);
//				System.out.println(a.getNombre()+"-"+a.getApellido());
//				String apellido = "Torres Fernandez";
//				a.setApellido(apellido);
//				System.out.println(a.getNombre()+"-"+a.getApellido());
//				session.update(a);
//				session.getTransaction().commit();
//				session.close();
//				Alumnos alumno_modificar = alumnosDAO.buscarId(Integer.parseInt(identificador));
				session.beginTransaction();
				Alumnos alumno_modificar = new Alumnos();
				String id = pantallaAlumnos_Modificar_textFieldId.getText();
				String nombre = pantallaAlumnos_Modificar_textFieldNombre.getText();
				String apellidos = pantallaAlumnos_Modificar_textFieldApellidos.getText();
				Object curso = pantallaAlumnos_Modificar_comboBoxCurso.getSelectedItem();
				alumno_modificar.setId_Alumno(Integer.parseInt(id));
				alumno_modificar.setNombre(nombre);
				alumno_modificar.setApellido(apellidos);
				alumno_modificar.setCurso((String)curso);
				session.merge(alumno_modificar);
//				session.update(alumno_modificar);
				session.getTransaction().commit();
				JOptionPane.showMessageDialog(panelPrincipal, "Se ha modificado un registro en la base de datos.","Modificación de datos.",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		pantallaAlumnos_Modificar_btnConfirmar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		pantallaAlumnos_Modificar_btnConfirmar.setIcon(new ImageIcon(Principal.class.getResource("/Res/alta.png")));
		
		pantallaAlumnos_Modificar_btnLimpiarCampos = new JButton("Limpiar Campos");
		pantallaAlumnos_Modificar_btnLimpiarCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pantallaAlumnos_Modificar_textFieldBuscarId.setText("");
				pantallaAlumnos_Modificar_textFieldId.setText("");
				pantallaAlumnos_Modificar_textFieldNombre.setText("");
				pantallaAlumnos_Modificar_textFieldApellidos.setText("");
				pantallaAlumnos_Modificar_comboBoxCurso.setSelectedIndex(0);
				pantallaAlumnos_Modificar_btnConfirmar.setEnabled(false);
				pantallaAlumnos_Modificar_textFieldApellidos.setEnabled(false);
				pantallaAlumnos_Modificar_textFieldId.setEnabled(false);
				pantallaAlumnos_Modificar_textFieldNombre.setEnabled(false);
				pantallaAlumnos_Modificar_comboBoxCurso.setEnabled(false);
			}
		});
		pantallaAlumnos_Modificar_btnLimpiarCampos.setIcon(new ImageIcon(Principal.class.getResource("/Res/limpiar.gif")));
		pantallaAlumnos_Modificar_btnLimpiarCampos.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		pantallaAlumnos_Modificar_btnBuscar = new JButton("Buscar");
		pantallaAlumnos_Modificar_btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				session.beginTransaction();
//				Alumnos a = alumnosDAO.buscarId(1);
//				System.out.println(a.getNombre()+"-"+a.getApellido());
//				String apellido = "Torres Fernandez";
//				a.setApellido(apellido);
//				System.out.println(a.getNombre()+"-"+a.getApellido());
//				session.update(a);
//				session.getTransaction().commit();
//				session.close();
				String identificador = pantallaAlumnos_Modificar_textFieldBuscarId.getText();
//				Alumnos alumno_modificar = alumnosDAO.buscarId(Integer.parseInt(identificador));
				Alumnos alumno_modificar = buscarId(Integer.parseInt(identificador), session);
				if(alumno_modificar==null){
					Object [] texto={"Confirmar","Cancelar"};
					JOptionPane.showOptionDialog (panelPrincipal,"Error, identificador no encontrado.", "Error campo identificador.", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE,null, texto, texto[0]);
					pantallaAlumnos_Modificar_btnConfirmar.setEnabled(false);
					pantallaAlumnos_Modificar_textFieldApellidos.setEnabled(false);
					pantallaAlumnos_Modificar_textFieldId.setEnabled(false);
					pantallaAlumnos_Modificar_textFieldNombre.setEnabled(false);
					pantallaAlumnos_Modificar_comboBoxCurso.setEnabled(false);
				}else{
					pantallaAlumnos_Modificar_btnConfirmar.setEnabled(true);
					pantallaAlumnos_Modificar_textFieldApellidos.setEnabled(true);
					pantallaAlumnos_Modificar_textFieldId.setEnabled(true);
					pantallaAlumnos_Modificar_textFieldNombre.setEnabled(true);
					pantallaAlumnos_Modificar_comboBoxCurso.setEnabled(true);
					pantallaAlumnos_Modificar_textFieldApellidos.setText(alumno_modificar.getApellido());
					pantallaAlumnos_Modificar_textFieldId.setText(String.valueOf(alumno_modificar.getId_Alumno()));
					pantallaAlumnos_Modificar_textFieldNombre.setText(alumno_modificar.getNombre());
					pantallaAlumnos_Modificar_comboBoxCurso.setSelectedItem(alumno_modificar.getCurso());
				}
			}
		});
		pantallaAlumnos_Modificar_btnBuscar.setIcon(new ImageIcon(Principal.class.getResource("/Res/buscar.jpg")));
		pantallaAlumnos_Modificar_btnBuscar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		GroupLayout gl_pantallaAlumnos_Modificar = new GroupLayout(pantallaAlumnos_Modificar);
		gl_pantallaAlumnos_Modificar.setHorizontalGroup(
			gl_pantallaAlumnos_Modificar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pantallaAlumnos_Modificar.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pantallaAlumnos_Modificar.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_pantallaAlumnos_Modificar.createSequentialGroup()
							.addComponent(pantallaAlumnos_Modificar_btnVolver)
							.addPreferredGap(ComponentPlacement.RELATED, 343, Short.MAX_VALUE)
							.addComponent(pantallaAlumnos_Modificar_lblModificarDatosAlumno)
							.addGap(25))
						.addGroup(Alignment.LEADING, gl_pantallaAlumnos_Modificar.createSequentialGroup()
							.addGroup(gl_pantallaAlumnos_Modificar.createParallelGroup(Alignment.LEADING)
								.addComponent(pantallaAlumnos_Modificar_lblIdentificador)
								.addComponent(pantallaAlumnos_Modificar_lblNombre))
							.addGap(18)
							.addGroup(gl_pantallaAlumnos_Modificar.createParallelGroup(Alignment.LEADING)
								.addComponent(pantallaAlumnos_Modificar_textFieldId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(pantallaAlumnos_Modificar_textFieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(67)
							.addGroup(gl_pantallaAlumnos_Modificar.createParallelGroup(Alignment.LEADING)
								.addComponent(pantallaAlumnos_Modificar_lblApellidos)
								.addComponent(pantallaAlumnos_Modificar_lblCurso))
							.addGap(33)
							.addGroup(gl_pantallaAlumnos_Modificar.createParallelGroup(Alignment.LEADING, false)
								.addComponent(pantallaAlumnos_Modificar_comboBoxCurso, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(pantallaAlumnos_Modificar_textFieldApellidos))
							.addContainerGap(201, Short.MAX_VALUE))
						.addGroup(gl_pantallaAlumnos_Modificar.createSequentialGroup()
							.addGroup(gl_pantallaAlumnos_Modificar.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_pantallaAlumnos_Modificar.createSequentialGroup()
									.addComponent(pantallaAlumnos_Modificar_btnLimpiarCampos)
									.addGap(18))
								.addGroup(gl_pantallaAlumnos_Modificar.createSequentialGroup()
									.addComponent(pantallaAlumnos_Modificar_lblIntroduzcaElIdentificador)
									.addGap(18)
									.addComponent(pantallaAlumnos_Modificar_textFieldBuscarId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(82)))
							.addGroup(gl_pantallaAlumnos_Modificar.createParallelGroup(Alignment.LEADING)
								.addComponent(pantallaAlumnos_Modificar_btnConfirmar)
								.addComponent(pantallaAlumnos_Modificar_btnBuscar, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())))
		);
		gl_pantallaAlumnos_Modificar.setVerticalGroup(
			gl_pantallaAlumnos_Modificar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pantallaAlumnos_Modificar.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pantallaAlumnos_Modificar.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_pantallaAlumnos_Modificar.createParallelGroup(Alignment.BASELINE)
							.addComponent(pantallaAlumnos_Modificar_textFieldBuscarId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(pantallaAlumnos_Modificar_btnBuscar))
						.addGroup(gl_pantallaAlumnos_Modificar.createSequentialGroup()
							.addGroup(gl_pantallaAlumnos_Modificar.createParallelGroup(Alignment.BASELINE)
								.addComponent(pantallaAlumnos_Modificar_btnVolver)
								.addComponent(pantallaAlumnos_Modificar_lblModificarDatosAlumno))
							.addGap(38)
							.addComponent(pantallaAlumnos_Modificar_lblIntroduzcaElIdentificador)))
					.addGap(63)
					.addGroup(gl_pantallaAlumnos_Modificar.createParallelGroup(Alignment.BASELINE)
						.addComponent(pantallaAlumnos_Modificar_lblIdentificador)
						.addComponent(pantallaAlumnos_Modificar_lblCurso)
						.addComponent(pantallaAlumnos_Modificar_textFieldId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(pantallaAlumnos_Modificar_comboBoxCurso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addGroup(gl_pantallaAlumnos_Modificar.createParallelGroup(Alignment.BASELINE)
						.addComponent(pantallaAlumnos_Modificar_lblNombre)
						.addComponent(pantallaAlumnos_Modificar_lblApellidos)
						.addComponent(pantallaAlumnos_Modificar_textFieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(pantallaAlumnos_Modificar_textFieldApellidos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
					.addGroup(gl_pantallaAlumnos_Modificar.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(pantallaAlumnos_Modificar_btnLimpiarCampos, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(pantallaAlumnos_Modificar_btnConfirmar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		pantallaAlumnos_Modificar.setLayout(gl_pantallaAlumnos_Modificar);
		
		pantallaAlumnos_Baja = new JPanel();
		pantallaAlumnos_Baja.setBackground(Color.CYAN);
		panelPrincipal.add(pantallaAlumnos_Baja, "name_58549444208132");
		
		pantallaAlumnos_Baja_btnVolver = new JButton("Volver");
		pantallaAlumnos_Baja_btnVolver.setIcon(new ImageIcon(Principal.class.getResource("/Res/icono-volver.png")));
		pantallaAlumnos_Baja_btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout l =(CardLayout)panelPrincipal.getLayout();
				l.show(panelPrincipal,"name_19970894796126");
			}
		});
		pantallaAlumnos_Baja_btnVolver.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		pantallaAlumnos_Baja_lblDarDeBaja = new JLabel("Dar de Baja a Alumno");
		pantallaAlumnos_Baja_lblDarDeBaja.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		pantallaAlumnos_Baja_comboBoxId = new JComboBox();
		pantallaAlumnos_Baja_comboBoxId.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		pantallaAlumnos_Baja_comboBoxId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = (int) pantallaAlumnos_Baja_comboBoxId.getSelectedItem();
				Alumnos alumnos = alumnosDAO.buscarId(id);
				pantallaAlumnos_Baja_lblInfo.setText("ID: "+alumnos.getId_Alumno()+" - Nombre: "+alumnos.getNombre()+" - Apellidos: "+alumnos.getApellido()+" - Curso: "+alumnos.getCurso());
			}
		});
		
		pantallaAlumnos_Baja_lblSelecionarAlumno = new JLabel("Selecionar Alumno");
		pantallaAlumnos_Baja_lblSelecionarAlumno.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		pantallaAlumnos_Baja_btnConfirmar = new JButton("Confirmar");
		pantallaAlumnos_Baja_btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int alumnos_id = (int) pantallaAlumnos_Baja_comboBoxId.getSelectedItem();
					Alumnos alumnos = alumnosDAO.buscarId(alumnos_id);
					Faltas faltas = new Faltas();
					faltas = faltasDAO.buscarFaltasPorId_Alumno(alumnos_id);
					Modulos modulo = new Modulos();
					modulo = faltas.getModulo();
					String modulos = modulo.getNombre();
					if(modulos.equals("") || modulo == null || modulos == null){
						session.beginTransaction();
						session.delete(alumnos);
						session.getTransaction().commit();
						JOptionPane.showMessageDialog(panelPrincipal, "El alumno selecionado se ha eliminado correctamente.","Confirmación baja de alumno.",JOptionPane.INFORMATION_MESSAGE);
					}else{
						Object [] texto={"Confirmar","Cancelar"};
						JOptionPane.showOptionDialog (panelPrincipal,"El alumno está matriculado en algún módulo profesional.", "Error alumno matriculado.", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE,null, texto, texto[0]);
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				} catch (NullPointerException e1) {
					int alumnos_id = (int) pantallaAlumnos_Baja_comboBoxId.getSelectedItem();
					Alumnos alumnos = alumnosDAO.buscarId(alumnos_id);
					session.beginTransaction();
					session.delete(alumnos);
					session.getTransaction().commit();
					JOptionPane.showMessageDialog(panelPrincipal, "El alumno selecionado se ha eliminado correctamente.","Confirmación baja de alumno.",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		pantallaAlumnos_Baja_btnConfirmar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		pantallaAlumnos_Baja_btnConfirmar.setIcon(new ImageIcon(Principal.class.getResource("/Res/alta.png")));
		
		pantallaAlumnos_Baja_lblInfo = new JLabel("");
		pantallaAlumnos_Baja_lblInfo.setFont(new Font("Times New Roman", Font.BOLD, 12));
		GroupLayout gl_pantallaAlumnos_Baja = new GroupLayout(pantallaAlumnos_Baja);
		gl_pantallaAlumnos_Baja.setHorizontalGroup(
			gl_pantallaAlumnos_Baja.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pantallaAlumnos_Baja.createSequentialGroup()
					.addGroup(gl_pantallaAlumnos_Baja.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pantallaAlumnos_Baja.createSequentialGroup()
							.addContainerGap()
							.addComponent(pantallaAlumnos_Baja_btnVolver))
						.addGroup(gl_pantallaAlumnos_Baja.createSequentialGroup()
							.addGap(45)
							.addComponent(pantallaAlumnos_Baja_lblSelecionarAlumno)))
					.addGroup(gl_pantallaAlumnos_Baja.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pantallaAlumnos_Baja.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 313, Short.MAX_VALUE)
							.addComponent(pantallaAlumnos_Baja_lblDarDeBaja)
							.addGap(21))
						.addGroup(gl_pantallaAlumnos_Baja.createSequentialGroup()
							.addGap(93)
							.addComponent(pantallaAlumnos_Baja_comboBoxId, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
				.addGroup(gl_pantallaAlumnos_Baja.createSequentialGroup()
					.addContainerGap(472, Short.MAX_VALUE)
					.addComponent(pantallaAlumnos_Baja_btnConfirmar)
					.addContainerGap())
				.addGroup(Alignment.LEADING, gl_pantallaAlumnos_Baja.createSequentialGroup()
					.addGap(53)
					.addComponent(pantallaAlumnos_Baja_lblInfo)
					.addContainerGap(518, Short.MAX_VALUE))
		);
		gl_pantallaAlumnos_Baja.setVerticalGroup(
			gl_pantallaAlumnos_Baja.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pantallaAlumnos_Baja.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pantallaAlumnos_Baja.createParallelGroup(Alignment.BASELINE)
						.addComponent(pantallaAlumnos_Baja_lblDarDeBaja)
						.addComponent(pantallaAlumnos_Baja_btnVolver))
					.addGap(39)
					.addGroup(gl_pantallaAlumnos_Baja.createParallelGroup(Alignment.BASELINE)
						.addComponent(pantallaAlumnos_Baja_comboBoxId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(pantallaAlumnos_Baja_lblSelecionarAlumno))
					.addGap(57)
					.addComponent(pantallaAlumnos_Baja_lblInfo)
					.addPreferredGap(ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
					.addComponent(pantallaAlumnos_Baja_btnConfirmar)
					.addContainerGap())
		);
		pantallaAlumnos_Baja.setLayout(gl_pantallaAlumnos_Baja);
		
		JPanel pantallaModulos_GestionarAlumnado = new JPanel();
		pantallaModulos_GestionarAlumnado.setBackground(Color.CYAN);
		panelPrincipal.add(pantallaModulos_GestionarAlumnado, "name_59369311308280");
		
		pantallaModulos_GestionarAlumnado_btnVolver = new JButton("Volver");
		pantallaModulos_GestionarAlumnado_btnVolver.setIcon(new ImageIcon(Principal.class.getResource("/Res/icono-volver.png")));
		pantallaModulos_GestionarAlumnado_btnVolver.setFont(new Font("Times New Roman", Font.BOLD, 12));
		pantallaModulos_GestionarAlumnado_btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout l =(CardLayout)panelPrincipal.getLayout();
				l.show(panelPrincipal,"name_20472107377334");
			}
		});
		
		lblGestionarAlumnadoMdulo = new JLabel("Gestionar Alumnado M\u00F3dulo Profesional");
		lblGestionarAlumnadoMdulo.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		pantallaModulos_GestionarAlumnado_btnMatricular = new JButton("Matricular");
		pantallaModulos_GestionarAlumnado_btnMatricular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout l =(CardLayout)panelPrincipal.getLayout();
				l.show(panelPrincipal,"name_61896211686401");
			}
		});
		pantallaModulos_GestionarAlumnado_btnMatricular.setIcon(new ImageIcon(Principal.class.getResource("/Res/matricular.gif")));
		pantallaModulos_GestionarAlumnado_btnMatricular.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		pantallaModulos_GestionarAlumnado_btnDesmatricular = new JButton("Desmatricular");
		pantallaModulos_GestionarAlumnado_btnDesmatricular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout l =(CardLayout)panelPrincipal.getLayout();
				l.show(panelPrincipal,"name_61917637729934");
				List <Alumnos> alumnos = alumnosDAO.listarTodos();
				if(alumnos != null){
					for(Alumnos a : alumnos){
						if(a != null){
							pantallaModulos_GestionarAlumnado_Desmatricular_comboBoxIdAlumno.addItem(a.getId_Alumno());
						}
					}
				}
				List <Modulos> modulos = modulosDAO.listarTodos();
				if(modulos != null){
					for(Modulos m : modulos){
						if(m != null){
							pantallaModulos_GestionarAlumnado_Desmatricular_comboBoxIdModulo.addItem(m.getId_Modulo());
						}
					}
				}
			}
		});
		pantallaModulos_GestionarAlumnado_btnDesmatricular.setIcon(new ImageIcon(Principal.class.getResource("/Res/desmatricular.png")));
		pantallaModulos_GestionarAlumnado_btnDesmatricular.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JLabel pantallaModulos_GestionarAlumnado_lblMatricularAlumnado = new JLabel("Matricular Alumnado.");
		pantallaModulos_GestionarAlumnado_lblMatricularAlumnado.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JLabel pantallaModulos_GestionarAlumnado_lblDesmatricularAlumnado = new JLabel("Desmatricular Alumnado.");
		pantallaModulos_GestionarAlumnado_lblDesmatricularAlumnado.setFont(new Font("Times New Roman", Font.BOLD, 12));
		GroupLayout gl_pantallaModulos_GestionarAlumnado = new GroupLayout(pantallaModulos_GestionarAlumnado);
		gl_pantallaModulos_GestionarAlumnado.setHorizontalGroup(
			gl_pantallaModulos_GestionarAlumnado.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pantallaModulos_GestionarAlumnado.createSequentialGroup()
					.addContainerGap()
					.addComponent(pantallaModulos_GestionarAlumnado_btnVolver)
					.addPreferredGap(ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
					.addComponent(lblGestionarAlumnadoMdulo)
					.addGap(32))
				.addGroup(Alignment.LEADING, gl_pantallaModulos_GestionarAlumnado.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_pantallaModulos_GestionarAlumnado.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(pantallaModulos_GestionarAlumnado_btnDesmatricular, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(pantallaModulos_GestionarAlumnado_btnMatricular, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
					.addGap(53)
					.addGroup(gl_pantallaModulos_GestionarAlumnado.createParallelGroup(Alignment.LEADING)
						.addComponent(pantallaModulos_GestionarAlumnado_lblMatricularAlumnado)
						.addComponent(pantallaModulos_GestionarAlumnado_lblDesmatricularAlumnado))
					.addContainerGap(194, Short.MAX_VALUE))
		);
		gl_pantallaModulos_GestionarAlumnado.setVerticalGroup(
			gl_pantallaModulos_GestionarAlumnado.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pantallaModulos_GestionarAlumnado.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pantallaModulos_GestionarAlumnado.createParallelGroup(Alignment.LEADING)
						.addComponent(lblGestionarAlumnadoMdulo)
						.addComponent(pantallaModulos_GestionarAlumnado_btnVolver))
					.addGap(18)
					.addGroup(gl_pantallaModulos_GestionarAlumnado.createParallelGroup(Alignment.BASELINE)
						.addComponent(pantallaModulos_GestionarAlumnado_btnMatricular, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
						.addComponent(pantallaModulos_GestionarAlumnado_lblMatricularAlumnado))
					.addGap(40)
					.addGroup(gl_pantallaModulos_GestionarAlumnado.createParallelGroup(Alignment.BASELINE)
						.addComponent(pantallaModulos_GestionarAlumnado_btnDesmatricular, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
						.addComponent(pantallaModulos_GestionarAlumnado_lblDesmatricularAlumnado))
					.addContainerGap(54, Short.MAX_VALUE))
		);
		pantallaModulos_GestionarAlumnado.setLayout(gl_pantallaModulos_GestionarAlumnado);

		pantallaModulos_Alta = new JPanel();
		pantallaModulos_Alta.setBackground(Color.CYAN);
		panelPrincipal.add(pantallaModulos_Alta, "name_59753157630927");
		
		pantallaModulos_Alta_btnVolver = new JButton("Volver");
		pantallaModulos_Alta_btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout l =(CardLayout)panelPrincipal.getLayout();
				l.show(panelPrincipal,"name_20472107377334");
			}
		});
		pantallaModulos_Alta_btnVolver.setIcon(new ImageIcon(Principal.class.getResource("/Res/icono-volver.png")));
		pantallaModulos_Alta_btnVolver.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		pantallaModulos_Alta_lblDarDeAlta = new JLabel("Dar de Alta un M\u00F3dulo Profesional");
		pantallaModulos_Alta_lblDarDeAlta.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JLabel pantallaModulos_Alta_lblIdentificador = new JLabel("Identificador");
		pantallaModulos_Alta_lblIdentificador.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JLabel pantallaModulos_Alta_lblNombre = new JLabel("Nombre");
		pantallaModulos_Alta_lblNombre.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JLabel pantallaModulos_Alta_lblSiglas = new JLabel("Siglas");
		pantallaModulos_Alta_lblSiglas.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JLabel pantallaModulos_Alta_lblCurso = new JLabel("Curso");
		pantallaModulos_Alta_lblCurso.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JLabel pantallaModulos_Alta_lblNHoras = new JLabel("N\u00BA Horas");
		pantallaModulos_Alta_lblNHoras.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JLabel pantallaModulos_Alta_lblPorcentaje = new JLabel("Porcentaje");
		pantallaModulos_Alta_lblPorcentaje.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		pantallaModulos_Alta_textFieldIdentificador = new JTextField();
		pantallaModulos_Alta_textFieldIdentificador.setColumns(10);
		
		pantallaModulos_Alta_textFieldNombre = new JTextField();
		pantallaModulos_Alta_textFieldNombre.setColumns(10);
		
		pantallaModulos_Alta_textFieldSiglas = new JTextField();
		pantallaModulos_Alta_textFieldSiglas.setColumns(10);
		
		pantallaModulos_Alta_textFieldHoras = new JTextField();
		pantallaModulos_Alta_textFieldHoras.setColumns(10);
		
		pantallaModulos_Alta_textFieldPorcentaje = new JTextField();
		pantallaModulos_Alta_textFieldPorcentaje.setColumns(10);
		
		pantallaModulos_Alta_btnConfirmar = new JButton("Confirmar");
		pantallaModulos_Alta_btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Modulos modulo = new Modulos();
					String id = pantallaModulos_Alta_textFieldIdentificador.getText();
					String nombre = pantallaModulos_Alta_textFieldNombre.getText();
					String siglas = pantallaModulos_Alta_textFieldSiglas.getText();
					String porcentaje = pantallaModulos_Alta_textFieldPorcentaje.getText();
					String horas = pantallaModulos_Alta_textFieldHoras.getText();
					Object curso = pantallaModulos_Alta_comboBoxCurso.getSelectedItem();
					modulo.setId_Modulo(Integer.parseInt(id));
					modulo.setNombre(nombre);
					modulo.setSiglas(siglas);
					modulo.setPorcentaje(Integer.parseInt(porcentaje));
					modulo.setHoras(Integer.parseInt(horas));
					modulo.setCurso((String)curso);
					if(Integer.parseInt(id)<0){
						Object [] texto={"Confirmar","Cancelar"};
						JOptionPane.showOptionDialog (panelPrincipal,"Debes introducir todos los campos.", "Error entrada de datos.", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE,null, texto, texto[0]);
					}else if(nombre.equals(" ")){
						Object [] texto={"Confirmar","Cancelar"};
						JOptionPane.showOptionDialog (panelPrincipal,"Debes introducir todos los campos.", "Error entrada de datos.", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE,null, texto, texto[0]);
					}else if(siglas.equals(" ")){
						Object [] texto={"Confirmar","Cancelar"};
						JOptionPane.showOptionDialog (panelPrincipal,"Debes introducir todos los campos.", "Error entrada de datos.", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE,null, texto, texto[0]);
					}else if(Integer.parseInt(porcentaje)<0){
						Object [] texto={"Confirmar","Cancelar"};
						JOptionPane.showOptionDialog (panelPrincipal,"Debes introducir todos los campos.", "Error entrada de datos.", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE,null, texto, texto[0]);
					}else if(Integer.parseInt(horas)<0){
						Object [] texto={"Confirmar","Cancelar"};
						JOptionPane.showOptionDialog (panelPrincipal,"Debes introducir todos los campos.", "Error entrada de datos.", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE,null, texto, texto[0]);
					}else{
						session.beginTransaction();
						session.save(modulo);
						session.getTransaction().commit();
						JOptionPane.showMessageDialog(panelPrincipal, "Se ha insertado un registro en la base de datos.","Entrada de datos.",JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (NumberFormatException e1) {
					Object [] texto={"Confirmar","Cancelar"};
					JOptionPane.showOptionDialog (panelPrincipal,"Debes introducir todos los campos.", "Error entrada de datos.", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE,null, texto, texto[0]);
				} catch (HeadlessException e1) {
					Object [] texto={"Confirmar","Cancelar"};
					JOptionPane.showOptionDialog (panelPrincipal,"Debes introducir todos los campos.", "Error entrada de datos.", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE,null, texto, texto[0]);
				}
			}
		});
		pantallaModulos_Alta_btnConfirmar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		pantallaModulos_Alta_btnConfirmar.setIcon(new ImageIcon(Principal.class.getResource("/Res/alta.png")));
		
		pantallaModulos_Alta_comboBoxCurso = new JComboBox();
		pantallaModulos_Alta_comboBoxCurso.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		pantallaModulos_Alta_comboBoxCurso.setModel(new DefaultComboBoxModel(new String[] {"1 DAM", "1 SMR", "2 DAM", "2 SMR"}));
		
		pantallaModulos_Alta_btnLimpiarCampo = new JButton("Limpiar Campo");
		pantallaModulos_Alta_btnLimpiarCampo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pantallaModulos_Alta_textFieldIdentificador.setText("");
				pantallaModulos_Alta_textFieldNombre.setText("");
				pantallaModulos_Alta_textFieldSiglas.setText("");
				pantallaModulos_Alta_textFieldPorcentaje.setText("");
				pantallaModulos_Alta_textFieldHoras.setText("");
				pantallaModulos_Alta_comboBoxCurso.setSelectedIndex(0);
			}
		});
		pantallaModulos_Alta_btnLimpiarCampo.setIcon(new ImageIcon(Principal.class.getResource("/Res/limpiar.gif")));
		pantallaModulos_Alta_btnLimpiarCampo.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JLabel pantallaModulos_Alta_lblPorcentajeAyuda = new JLabel("%");
		pantallaModulos_Alta_lblPorcentajeAyuda.setFont(new Font("Times New Roman", Font.BOLD, 12));
		GroupLayout gl_pantallaModulos_Alta = new GroupLayout(pantallaModulos_Alta);
		gl_pantallaModulos_Alta.setHorizontalGroup(
			gl_pantallaModulos_Alta.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pantallaModulos_Alta.createSequentialGroup()
					.addGroup(gl_pantallaModulos_Alta.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pantallaModulos_Alta.createSequentialGroup()
							.addContainerGap()
							.addComponent(pantallaModulos_Alta_btnVolver))
						.addGroup(gl_pantallaModulos_Alta.createSequentialGroup()
							.addGap(41)
							.addGroup(gl_pantallaModulos_Alta.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_pantallaModulos_Alta.createSequentialGroup()
									.addGroup(gl_pantallaModulos_Alta.createParallelGroup(Alignment.LEADING)
										.addComponent(pantallaModulos_Alta_lblNombre)
										.addComponent(pantallaModulos_Alta_lblSiglas))
									.addGap(43)
									.addGroup(gl_pantallaModulos_Alta.createParallelGroup(Alignment.TRAILING)
										.addComponent(pantallaModulos_Alta_textFieldSiglas, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
										.addComponent(pantallaModulos_Alta_textFieldNombre, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)))
								.addGroup(Alignment.LEADING, gl_pantallaModulos_Alta.createSequentialGroup()
									.addComponent(pantallaModulos_Alta_lblIdentificador)
									.addGap(18)
									.addComponent(pantallaModulos_Alta_textFieldIdentificador, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)))
							.addGap(45)
							.addGroup(gl_pantallaModulos_Alta.createParallelGroup(Alignment.LEADING)
								.addComponent(pantallaModulos_Alta_lblPorcentaje)
								.addComponent(pantallaModulos_Alta_lblCurso)
								.addComponent(pantallaModulos_Alta_lblNHoras))))
					.addGap(11)
					.addGroup(gl_pantallaModulos_Alta.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_pantallaModulos_Alta.createSequentialGroup()
							.addGroup(gl_pantallaModulos_Alta.createParallelGroup(Alignment.TRAILING)
								.addComponent(pantallaModulos_Alta_btnConfirmar)
								.addComponent(pantallaModulos_Alta_lblDarDeAlta))
							.addGap(30))
						.addGroup(gl_pantallaModulos_Alta.createSequentialGroup()
							.addGroup(gl_pantallaModulos_Alta.createParallelGroup(Alignment.LEADING, false)
								.addComponent(pantallaModulos_Alta_comboBoxCurso, Alignment.TRAILING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(pantallaModulos_Alta_textFieldHoras, Alignment.TRAILING)
								.addComponent(pantallaModulos_Alta_textFieldPorcentaje, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(pantallaModulos_Alta_lblPorcentajeAyuda)
							.addGap(29))))
				.addGroup(gl_pantallaModulos_Alta.createSequentialGroup()
					.addGap(292)
					.addComponent(pantallaModulos_Alta_btnLimpiarCampo)
					.addContainerGap(184, Short.MAX_VALUE))
		);
		gl_pantallaModulos_Alta.setVerticalGroup(
			gl_pantallaModulos_Alta.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pantallaModulos_Alta.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pantallaModulos_Alta.createParallelGroup(Alignment.BASELINE)
						.addComponent(pantallaModulos_Alta_btnVolver)
						.addComponent(pantallaModulos_Alta_lblDarDeAlta))
					.addGap(51)
					.addGroup(gl_pantallaModulos_Alta.createParallelGroup(Alignment.BASELINE)
						.addComponent(pantallaModulos_Alta_lblIdentificador)
						.addComponent(pantallaModulos_Alta_lblCurso)
						.addComponent(pantallaModulos_Alta_textFieldIdentificador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(pantallaModulos_Alta_comboBoxCurso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_pantallaModulos_Alta.createParallelGroup(Alignment.BASELINE)
						.addComponent(pantallaModulos_Alta_textFieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(pantallaModulos_Alta_textFieldHoras, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(pantallaModulos_Alta_lblNombre)
						.addComponent(pantallaModulos_Alta_lblNHoras))
					.addGap(26)
					.addGroup(gl_pantallaModulos_Alta.createParallelGroup(Alignment.BASELINE)
						.addComponent(pantallaModulos_Alta_lblSiglas)
						.addComponent(pantallaModulos_Alta_lblPorcentaje)
						.addComponent(pantallaModulos_Alta_textFieldPorcentaje, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(pantallaModulos_Alta_textFieldSiglas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(pantallaModulos_Alta_lblPorcentajeAyuda))
					.addPreferredGap(ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
					.addGroup(gl_pantallaModulos_Alta.createParallelGroup(Alignment.BASELINE)
						.addComponent(pantallaModulos_Alta_btnLimpiarCampo, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(pantallaModulos_Alta_btnConfirmar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		pantallaModulos_Alta.setLayout(gl_pantallaModulos_Alta);
		
		pantallaModulos_Baja = new JPanel();
		pantallaModulos_Baja.setBackground(Color.CYAN);
		panelPrincipal.add(pantallaModulos_Baja, "name_59824787721623");
		
		pantallaModulos_Baja_btnVolver = new JButton("Volver");
		pantallaModulos_Baja_btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout l =(CardLayout)panelPrincipal.getLayout();
				l.show(panelPrincipal,"name_20472107377334");
			}
		});
		pantallaModulos_Baja_btnVolver.setIcon(new ImageIcon(Principal.class.getResource("/Res/icono-volver.png")));
		pantallaModulos_Baja_btnVolver.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		pantallaModulos_Baja_lblDarDeBaja = new JLabel("Dar de Baja un M\u00F3dulo Profesional");
		pantallaModulos_Baja_lblDarDeBaja.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		pantallaModulos_Baja_comboBoxIdModulos = new JComboBox();
		pantallaModulos_Baja_comboBoxIdModulos.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		pantallaModulos_Baja_comboBoxIdModulos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = (int) pantallaModulos_Baja_comboBoxIdModulos.getSelectedItem();
				Modulos modulos = new Modulos();
				modulos = modulosDAO.buscarModuloPorId(id);
				pantallaModulos_Baja_lblInfo.setText("ID: "+modulos.getId_Modulo()+" - Nombre: "+modulos.getNombre()+" - Siglas: "+modulos.getSiglas()+" - Curso: "+modulos.getCurso()+" - Nº Horas: "+modulos.getHoras()+" - Porcentaje: "+modulos.getPorcentaje()+"%");
			}
		});
		
		pantallaModulos_Baja_lblIndicarMdulosProfesionales = new JLabel("Indicar M\u00F3dulos Profesionales");
		pantallaModulos_Baja_lblIndicarMdulosProfesionales.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		pantallaModulos_Baja_lblInfo = new JLabel("");
		
		pantallaModulos_Baja_btnConfirmar = new JButton("Confirmar");
		pantallaModulos_Baja_btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int id = (int) pantallaModulos_Baja_comboBoxIdModulos.getSelectedItem();
					Faltas faltas = new Faltas();
					faltas = faltasDAO.buscarFaltasporId_Modulo(id);
					Modulos modulos = new Modulos();
					modulos = modulosDAO.buscarModuloPorId(id);
					Alumnos alumnos = new Alumnos();
					alumnos = faltas.getAlumno();
					if(faltas.getAlumno() != null || faltas.getHoras() == 0){
						Object [] texto={"Confirmar","Cancelar"};
						int op = JOptionPane.showOptionDialog (panelPrincipal,"Se ha encontrados alumnos matriculados o faltas registradas.", "Mensaje de confirmación.", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,null, texto, texto[0]);
						if(op==0){
							session.beginTransaction();
							session.delete(modulos);
							session.delete(alumnos);
							session.getTransaction().commit();
							JOptionPane.showMessageDialog(panelPrincipal, "Se ha eliminado un registro en la base de datos.","Entrada de datos.",JOptionPane.INFORMATION_MESSAGE);
						}
					}else{
						session.beginTransaction();
						session.delete(modulos);
						session.delete(alumnos);
						session.getTransaction().commit();
						JOptionPane.showMessageDialog(panelPrincipal, "Se ha eliminado un registro en la base de datos.","Entrada de datos.",JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				} catch (NonUniqueResultException e1) {
					int id = (int) pantallaModulos_Baja_comboBoxIdModulos.getSelectedItem();
					List <Faltas> faltas = faltasDAO.buscarFaltasModulos(id);
					if(faltas != null){
						for(Faltas f:faltas){
							if(f != null){
								Modulos modulos = new Modulos(); 
								modulos = f.getModulo();
								Alumnos alumnos = f.getAlumno();
								if(f.getAlumno() != null || f.getHoras() == 0){
									Object [] texto={"Confirmar","Cancelar"};
									int op = JOptionPane.showOptionDialog (panelPrincipal,"Se ha encontrados alumnos matriculados o faltas registradas.", "Mensaje de confirmación.", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,null, texto, texto[0]);
									if(op==0){
										session.beginTransaction();
										session.delete(modulos);
										session.delete(alumnos);
										session.getTransaction().commit();
										JOptionPane.showMessageDialog(panelPrincipal, "Se ha eliminado un registro en la base de datos.","Entrada de datos.",JOptionPane.INFORMATION_MESSAGE);
									}
								}
							}
						}
					}
				} catch (NullPointerException e1) {
					int id = (int) pantallaModulos_Baja_comboBoxIdModulos.getSelectedItem();
					Modulos modulos = new Modulos();
					modulos = modulosDAO.buscarModuloPorId(id);
					session.beginTransaction();
					session.delete(modulos);
					session.getTransaction().commit();
				} catch (IllegalArgumentException e1){
					int id = (int) pantallaModulos_Baja_comboBoxIdModulos.getSelectedItem();
					Faltas faltas = new Faltas();
					faltas = faltasDAO.buscarFaltasporId_Modulo(id);
					Modulos modulos = new Modulos();
					modulos = modulosDAO.buscarModuloPorId(id);
					Alumnos alumnos = new Alumnos();
					alumnos = faltas.getAlumno();
					if(faltas.getAlumno() != null || faltas.getHoras() == 0){
						Object [] texto={"Confirmar","Cancelar"};
						int op = JOptionPane.showOptionDialog (panelPrincipal,"Se ha encontrados alumnos matriculados o faltas registradas.", "Mensaje de confirmación.", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,null, texto, texto[0]);
						if(op==0){
							session.beginTransaction();
							session.delete(modulos);
							session.delete(alumnos);
							session.getTransaction().commit();
							JOptionPane.showMessageDialog(panelPrincipal, "Se ha eliminado un registro en la base de datos.","Entrada de datos.",JOptionPane.INFORMATION_MESSAGE);
						}
					}else{
						session.beginTransaction();
						session.delete(modulos);
						session.delete(alumnos);
						session.getTransaction().commit();
						JOptionPane.showMessageDialog(panelPrincipal, "Se ha eliminado un registro en la base de datos.","Entrada de datos.",JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		pantallaModulos_Baja_btnConfirmar.setIcon(new ImageIcon(Principal.class.getResource("/Res/alta.png")));
		pantallaModulos_Baja_btnConfirmar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		GroupLayout gl_pantallaModulos_Baja = new GroupLayout(pantallaModulos_Baja);
		gl_pantallaModulos_Baja.setHorizontalGroup(
			gl_pantallaModulos_Baja.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pantallaModulos_Baja.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pantallaModulos_Baja.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pantallaModulos_Baja.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_pantallaModulos_Baja.createSequentialGroup()
								.addGroup(gl_pantallaModulos_Baja.createParallelGroup(Alignment.LEADING)
									.addComponent(pantallaModulos_Baja_lblIndicarMdulosProfesionales)
									.addComponent(pantallaModulos_Baja_btnVolver))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_pantallaModulos_Baja.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_pantallaModulos_Baja.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
										.addComponent(pantallaModulos_Baja_lblDarDeBaja)
										.addGap(30))
									.addGroup(gl_pantallaModulos_Baja.createSequentialGroup()
										.addGap(127)
										.addComponent(pantallaModulos_Baja_comboBoxIdModulos, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
										.addContainerGap(166, Short.MAX_VALUE))))
							.addGroup(gl_pantallaModulos_Baja.createSequentialGroup()
								.addComponent(pantallaModulos_Baja_lblInfo)
								.addContainerGap(607, Short.MAX_VALUE)))
						.addGroup(Alignment.TRAILING, gl_pantallaModulos_Baja.createSequentialGroup()
							.addComponent(pantallaModulos_Baja_btnConfirmar)
							.addContainerGap())))
		);
		gl_pantallaModulos_Baja.setVerticalGroup(
			gl_pantallaModulos_Baja.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pantallaModulos_Baja.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pantallaModulos_Baja.createParallelGroup(Alignment.BASELINE)
						.addComponent(pantallaModulos_Baja_lblDarDeBaja)
						.addComponent(pantallaModulos_Baja_btnVolver))
					.addGap(41)
					.addGroup(gl_pantallaModulos_Baja.createParallelGroup(Alignment.BASELINE)
						.addComponent(pantallaModulos_Baja_comboBoxIdModulos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(pantallaModulos_Baja_lblIndicarMdulosProfesionales))
					.addGap(58)
					.addComponent(pantallaModulos_Baja_lblInfo)
					.addPreferredGap(ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
					.addComponent(pantallaModulos_Baja_btnConfirmar)
					.addContainerGap())
		);
		pantallaModulos_Baja.setLayout(gl_pantallaModulos_Baja);
		
		pantallaModulos_GestionarAlumnado_Matricular = new JPanel();
		pantallaModulos_GestionarAlumnado_Matricular.setBackground(Color.CYAN);
		panelPrincipal.add(pantallaModulos_GestionarAlumnado_Matricular, "name_61896211686401");
		
		pantallaModulos_GestionarAlumnado_Matricular_lblMatricularAlumnadoEn = new JLabel("Matricular Alumnado en un M\u00F3dulo Profesional");
		pantallaModulos_GestionarAlumnado_Matricular_lblMatricularAlumnadoEn.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		pantallaModulos_GestionarAlumnado_Matricular_btnVolver = new JButton("Volver");
		pantallaModulos_GestionarAlumnado_Matricular_btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout l =(CardLayout)panelPrincipal.getLayout();
				l.show(panelPrincipal,"name_59369311308280");
			}
		});
		pantallaModulos_GestionarAlumnado_Matricular_btnVolver.setIcon(new ImageIcon(Principal.class.getResource("/Res/icono-volver.png")));
		pantallaModulos_GestionarAlumnado_Matricular_btnVolver.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		pantallaModulos_GestionarAlumnado_Matricular_btnConfirmar = new JButton("Confirmar");
		pantallaModulos_GestionarAlumnado_Matricular_btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cursoAlumno = "";
				cursoAlumno = pantallaModulos_GestionarAlumnado_Matricular_lblCursoAlumno.getText() ;
				String cursoModulo = "";
				cursoModulo = pantallaModulos_GestionarAlumnado_Matricular_lblCursoModulo.getText();
				if(!cursoAlumno.equals(cursoModulo)){
					pantallaModulos_GestionarAlumnado_Matricular_btnConfirmar.setEnabled(false);
				}else{
					String idAlumno = pantallaModulos_GestionarAlumnado_Matricular_textFieldIdAlumno.getText();
					String idModulo = pantallaModulos_GestionarAlumnado_Matricular_textFieldIdModulo.getText();

					Faltas faltas = new Faltas();
					FaltasId faltasId = new FaltasId();
					faltasId.setId_Alumno(Integer.parseInt(idAlumno));
					faltasId.setId_Modulo(Integer.parseInt(idModulo));
					faltas.setId(faltasId);
					session.beginTransaction();
					session.save(faltas);
					session.getTransaction().commit();
					JOptionPane.showMessageDialog(panelPrincipal, "Se ha matriculado a un alumno.","Matricular.",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		pantallaModulos_GestionarAlumnado_Matricular_btnConfirmar.setIcon(new ImageIcon(Principal.class.getResource("/Res/alta.png")));
		pantallaModulos_GestionarAlumnado_Matricular_btnConfirmar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		pantallaModulos_GestionarAlumnado_Matricular_btnLimpiarCampo = new JButton("Limpiar Campo");
		pantallaModulos_GestionarAlumnado_Matricular_btnLimpiarCampo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pantallaModulos_GestionarAlumnado_Matricular_textFieldIdAlumno.setText("");
				pantallaModulos_GestionarAlumnado_Matricular_textFieldIdModulo.setText("");
			}
		});
		pantallaModulos_GestionarAlumnado_Matricular_btnLimpiarCampo.setFont(new Font("Times New Roman", Font.BOLD, 12));
		pantallaModulos_GestionarAlumnado_Matricular_btnLimpiarCampo.setIcon(new ImageIcon(Principal.class.getResource("/Res/limpiar.gif")));
		
		pantallaModulos_GestionarAlumnado_Matricular_lblIdentificadorAlumno = new JLabel("Identificador Alumno");
		pantallaModulos_GestionarAlumnado_Matricular_lblIdentificadorAlumno.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		pantallaModulos_GestionarAlumnado_Matricular_lblIdentificadorMdulo = new JLabel("Identificador M\u00F3dulo");
		pantallaModulos_GestionarAlumnado_Matricular_lblIdentificadorMdulo.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		pantallaModulos_GestionarAlumnado_Matricular_textFieldIdAlumno = new JTextField();
		pantallaModulos_GestionarAlumnado_Matricular_textFieldIdAlumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id = pantallaModulos_GestionarAlumnado_Matricular_textFieldIdAlumno.getText();
				int id_alumno = Integer.parseInt(id);
				Alumnos alumno = new Alumnos();
				alumno = alumnosDAO.buscarId(id_alumno);
				if(alumno != null){
					pantallaModulos_GestionarAlumnado_Matricular_lblCursoAlumno.setText(alumno.getCurso());
					pantallaModulos_GestionarAlumnado_Matricular_btnConfirmar.setEnabled(true);
				}else {
					pantallaModulos_GestionarAlumnado_Matricular_lblCursoAlumno.setText("Identificador no válido.");
					pantallaModulos_GestionarAlumnado_Matricular_btnConfirmar.setEnabled(false);
				}
			}
		});
		pantallaModulos_GestionarAlumnado_Matricular_textFieldIdAlumno.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		pantallaModulos_GestionarAlumnado_Matricular_textFieldIdAlumno.setColumns(10);
		
		pantallaModulos_GestionarAlumnado_Matricular_textFieldIdModulo = new JTextField();
		pantallaModulos_GestionarAlumnado_Matricular_textFieldIdModulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id = pantallaModulos_GestionarAlumnado_Matricular_textFieldIdModulo.getText();
				int id_modulo = Integer.parseInt(id);
				Modulos modulo = new Modulos();
				modulo = modulosDAO.buscarModuloPorId(id_modulo);
				if(modulo != null){
					pantallaModulos_GestionarAlumnado_Matricular_lblCursoModulo.setText(modulo.getCurso());
					pantallaModulos_GestionarAlumnado_Matricular_btnConfirmar.setEnabled(true);
				}else{
					pantallaModulos_GestionarAlumnado_Matricular_lblCursoModulo.setText("Identificador no válido.");
					pantallaModulos_GestionarAlumnado_Matricular_btnConfirmar.setEnabled(false);
				}
			}
		});
		
		pantallaModulos_GestionarAlumnado_Matricular_textFieldIdModulo.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		pantallaModulos_GestionarAlumnado_Matricular_textFieldIdModulo.setColumns(10);
		
		JLabel pantallaModulos_GestionarAlumnado_Matricular_lblInfoCursoAlumno = new JLabel("Curso Alumno:");
		pantallaModulos_GestionarAlumnado_Matricular_lblInfoCursoAlumno.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JLabel pantallaModulos_GestionarAlumnado_Matricular_lblInfoCursoMdulo = new JLabel("Curso M\u00F3dulo:");
		pantallaModulos_GestionarAlumnado_Matricular_lblInfoCursoMdulo.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		pantallaModulos_GestionarAlumnado_Matricular_lblCursoAlumno = new JLabel("");
		pantallaModulos_GestionarAlumnado_Matricular_lblCursoAlumno.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		pantallaModulos_GestionarAlumnado_Matricular_lblCursoModulo = new JLabel("");
		pantallaModulos_GestionarAlumnado_Matricular_lblCursoModulo.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JButton pantallaModulos_GestionarAlumnado_Matricular_btnActualizar = new JButton("Actualizar");
		pantallaModulos_GestionarAlumnado_Matricular_btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pantallaModulos_GestionarAlumnado_Matricular_textFieldIdAlumno.setText("");
				pantallaModulos_GestionarAlumnado_Matricular_textFieldIdModulo.setText("");
				pantallaModulos_GestionarAlumnado_Matricular_lblCursoAlumno.setText("");
				pantallaModulos_GestionarAlumnado_Matricular_lblCursoModulo.setText("");
				pantallaModulos_GestionarAlumnado_Matricular_btnConfirmar.setEnabled(true);
			}
		});
		pantallaModulos_GestionarAlumnado_Matricular_btnActualizar.setIcon(new ImageIcon(Principal.class.getResource("/Res/icono_actualizar.gif")));
		pantallaModulos_GestionarAlumnado_Matricular_btnActualizar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		GroupLayout gl_pantallaModulos_GestionarAlumnado_Matricular = new GroupLayout(pantallaModulos_GestionarAlumnado_Matricular);
		gl_pantallaModulos_GestionarAlumnado_Matricular.setHorizontalGroup(
			gl_pantallaModulos_GestionarAlumnado_Matricular.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pantallaModulos_GestionarAlumnado_Matricular.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pantallaModulos_GestionarAlumnado_Matricular.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_pantallaModulos_GestionarAlumnado_Matricular.createSequentialGroup()
							.addComponent(pantallaModulos_GestionarAlumnado_Matricular_btnVolver)
							.addPreferredGap(ComponentPlacement.RELATED, 197, Short.MAX_VALUE)
							.addComponent(pantallaModulos_GestionarAlumnado_Matricular_lblMatricularAlumnadoEn)
							.addGap(28))
						.addGroup(gl_pantallaModulos_GestionarAlumnado_Matricular.createSequentialGroup()
							.addComponent(pantallaModulos_GestionarAlumnado_Matricular_btnActualizar)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(pantallaModulos_GestionarAlumnado_Matricular_btnLimpiarCampo)
							.addGap(18)
							.addComponent(pantallaModulos_GestionarAlumnado_Matricular_btnConfirmar)
							.addContainerGap())))
				.addGroup(gl_pantallaModulos_GestionarAlumnado_Matricular.createSequentialGroup()
					.addGap(84)
					.addGroup(gl_pantallaModulos_GestionarAlumnado_Matricular.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pantallaModulos_GestionarAlumnado_Matricular.createSequentialGroup()
							.addComponent(pantallaModulos_GestionarAlumnado_Matricular_lblIdentificadorAlumno)
							.addGap(46)
							.addComponent(pantallaModulos_GestionarAlumnado_Matricular_textFieldIdAlumno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pantallaModulos_GestionarAlumnado_Matricular.createSequentialGroup()
							.addComponent(pantallaModulos_GestionarAlumnado_Matricular_lblIdentificadorMdulo)
							.addGap(46)
							.addComponent(pantallaModulos_GestionarAlumnado_Matricular_textFieldIdModulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(50)
					.addGroup(gl_pantallaModulos_GestionarAlumnado_Matricular.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pantallaModulos_GestionarAlumnado_Matricular.createSequentialGroup()
							.addComponent(pantallaModulos_GestionarAlumnado_Matricular_lblInfoCursoMdulo)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(pantallaModulos_GestionarAlumnado_Matricular_lblCursoModulo))
						.addGroup(gl_pantallaModulos_GestionarAlumnado_Matricular.createSequentialGroup()
							.addComponent(pantallaModulos_GestionarAlumnado_Matricular_lblInfoCursoAlumno)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(pantallaModulos_GestionarAlumnado_Matricular_lblCursoAlumno)))
					.addContainerGap(138, Short.MAX_VALUE))
		);
		gl_pantallaModulos_GestionarAlumnado_Matricular.setVerticalGroup(
			gl_pantallaModulos_GestionarAlumnado_Matricular.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pantallaModulos_GestionarAlumnado_Matricular.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pantallaModulos_GestionarAlumnado_Matricular.createParallelGroup(Alignment.BASELINE)
						.addComponent(pantallaModulos_GestionarAlumnado_Matricular_lblMatricularAlumnadoEn)
						.addComponent(pantallaModulos_GestionarAlumnado_Matricular_btnVolver))
					.addGap(62)
					.addGroup(gl_pantallaModulos_GestionarAlumnado_Matricular.createParallelGroup(Alignment.BASELINE)
						.addComponent(pantallaModulos_GestionarAlumnado_Matricular_lblIdentificadorAlumno)
						.addComponent(pantallaModulos_GestionarAlumnado_Matricular_textFieldIdAlumno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(pantallaModulos_GestionarAlumnado_Matricular_lblInfoCursoAlumno)
						.addComponent(pantallaModulos_GestionarAlumnado_Matricular_lblCursoAlumno))
					.addGap(56)
					.addGroup(gl_pantallaModulos_GestionarAlumnado_Matricular.createParallelGroup(Alignment.TRAILING)
						.addComponent(pantallaModulos_GestionarAlumnado_Matricular_lblIdentificadorMdulo)
						.addGroup(gl_pantallaModulos_GestionarAlumnado_Matricular.createParallelGroup(Alignment.BASELINE)
							.addComponent(pantallaModulos_GestionarAlumnado_Matricular_textFieldIdModulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(pantallaModulos_GestionarAlumnado_Matricular_lblInfoCursoMdulo)
							.addComponent(pantallaModulos_GestionarAlumnado_Matricular_lblCursoModulo)))
					.addPreferredGap(ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
					.addGroup(gl_pantallaModulos_GestionarAlumnado_Matricular.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(pantallaModulos_GestionarAlumnado_Matricular_btnActualizar, 0, 0, Short.MAX_VALUE)
						.addComponent(pantallaModulos_GestionarAlumnado_Matricular_btnLimpiarCampo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(pantallaModulos_GestionarAlumnado_Matricular_btnConfirmar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		pantallaModulos_GestionarAlumnado_Matricular.setLayout(gl_pantallaModulos_GestionarAlumnado_Matricular);
		
		pantallaModulos_GestionarAlumnado_Desmatricular = new JPanel();
		pantallaModulos_GestionarAlumnado_Desmatricular.setBackground(Color.CYAN);
		panelPrincipal.add(pantallaModulos_GestionarAlumnado_Desmatricular, "name_61917637729934");
		
		pantallaModulos_GestionarAlumnado_Desmatricular_lblDesmatricularAlumnadoEn = new JLabel("Desmatricular Alumnado en un M\u00F3dulo Profesional");
		pantallaModulos_GestionarAlumnado_Desmatricular_lblDesmatricularAlumnadoEn.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		pantallaModulos_GestionarAlumnado_Desmatricular_btnVolver = new JButton("Volver");
		pantallaModulos_GestionarAlumnado_Desmatricular_btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout l =(CardLayout)panelPrincipal.getLayout();
				l.show(panelPrincipal,"name_59369311308280");
			}
		});
		pantallaModulos_GestionarAlumnado_Desmatricular_btnVolver.setIcon(new ImageIcon(Principal.class.getResource("/Res/icono-volver.png")));
		pantallaModulos_GestionarAlumnado_Desmatricular_btnVolver.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		pantallaModulos_GestionarAlumnado_Desmatricular_btnConfirmar = new JButton("Confirmar");
		pantallaModulos_GestionarAlumnado_Desmatricular_btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				int id_alumno = (int) pantallaModulos_GestionarAlumnado_Desmatricular_comboBoxIdAlumno.getSelectedItem();
				int id_modulo = (int) pantallaModulos_GestionarAlumnado_Desmatricular_comboBoxIdModulo.getSelectedItem();
				Faltas faltas = new Faltas();
				faltas = faltasDAO.buscarFaltasPorIdentificadores(id_alumno, id_modulo);
				if(faltas.getHoras()>=0){
					Object [] texto={"Confirmar","Cancelar"};
					int op = JOptionPane.showOptionDialog (panelPrincipal,"Se ha encontrados faltas registradas. ¿Quieres continuar?.", "Mensaje de confirmación.", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,null, texto, texto[0]);
					if(op==0){
						session.beginTransaction();
						session.delete(faltas);
						session.getTransaction().commit();
						JOptionPane.showMessageDialog(panelPrincipal, "Se ha desmatriculado a un alumno.","Desmatricular.",JOptionPane.INFORMATION_MESSAGE);
					}
				}
			} catch (NullPointerException e1) {
				JOptionPane.showMessageDialog(panelPrincipal, "Estas desmatriculando a un alumno perteneciente a otro curso, por favor indique otro identificador para selecionar el alumno correcto.","Desmatricular.",JOptionPane.ERROR_MESSAGE);
			}
			}
		});
		pantallaModulos_GestionarAlumnado_Desmatricular_btnConfirmar.setIcon(new ImageIcon(Principal.class.getResource("/Res/alta.png")));
		pantallaModulos_GestionarAlumnado_Desmatricular_btnConfirmar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		pantallaModulos_GestionarAlumnado_Desmatricular_lblIdentificadorAlumno = new JLabel("Identificador Alumno");
		pantallaModulos_GestionarAlumnado_Desmatricular_lblIdentificadorAlumno.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		pantallaModulos_GestionarAlumnado_Desmatricular_comboBoxIdAlumno = new JComboBox();
		pantallaModulos_GestionarAlumnado_Desmatricular_comboBoxIdAlumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int id = (int) pantallaModulos_GestionarAlumnado_Desmatricular_comboBoxIdAlumno.getSelectedItem();
			Alumnos alumnos = alumnosDAO.buscarId(id);
			pantallaModulos_GestionarAlumnado_Desmatricular_lblAlumno.setText("ID: "+alumnos.getId_Alumno()+" - Nombre: "+alumnos.getNombre()+" - Apellidos: "+alumnos.getApellido()+" - Curso: "+alumnos.getCurso());
			}
		});
		pantallaModulos_GestionarAlumnado_Desmatricular_comboBoxIdAlumno.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		JLabel pantallaModulos_GestionarAlumnado_Desmatricular_lblIdentificadorMdulo = new JLabel("Identificador M\u00F3dulo");
		pantallaModulos_GestionarAlumnado_Desmatricular_lblIdentificadorMdulo.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		pantallaModulos_GestionarAlumnado_Desmatricular_comboBoxIdModulo = new JComboBox();
		pantallaModulos_GestionarAlumnado_Desmatricular_comboBoxIdModulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = (int) pantallaModulos_GestionarAlumnado_Desmatricular_comboBoxIdModulo.getSelectedItem();
				Modulos modulos = modulosDAO.buscarModuloPorId(id);
				pantallaModulos_GestionarAlumnado_Desmatricular_lblModulo.setText("ID: "+modulos.getId_Modulo()+" - Nombre: "+modulos.getNombre()+" - Siglas: "+modulos.getSiglas()+" - Curso: "+modulos.getCurso()+" - Nº Horas: "+modulos.getHoras()+" - Porcentaje: "+modulos.getPorcentaje()+"%");
			}
		});
		pantallaModulos_GestionarAlumnado_Desmatricular_comboBoxIdModulo.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		pantallaModulos_GestionarAlumnado_Desmatricular_lblAlumno = new JLabel("");
		pantallaModulos_GestionarAlumnado_Desmatricular_lblAlumno.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		pantallaModulos_GestionarAlumnado_Desmatricular_lblModulo = new JLabel("");
		pantallaModulos_GestionarAlumnado_Desmatricular_lblModulo.setFont(new Font("Times New Roman", Font.BOLD, 12));
		GroupLayout gl_pantallaModulos_GestionarAlumnado_Desmatricular = new GroupLayout(pantallaModulos_GestionarAlumnado_Desmatricular);
		gl_pantallaModulos_GestionarAlumnado_Desmatricular.setHorizontalGroup(
			gl_pantallaModulos_GestionarAlumnado_Desmatricular.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pantallaModulos_GestionarAlumnado_Desmatricular.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pantallaModulos_GestionarAlumnado_Desmatricular.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_pantallaModulos_GestionarAlumnado_Desmatricular.createSequentialGroup()
							.addComponent(pantallaModulos_GestionarAlumnado_Desmatricular_btnVolver)
							.addPreferredGap(ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
							.addComponent(pantallaModulos_GestionarAlumnado_Desmatricular_lblDesmatricularAlumnadoEn)
							.addGap(28))
						.addGroup(gl_pantallaModulos_GestionarAlumnado_Desmatricular.createSequentialGroup()
							.addComponent(pantallaModulos_GestionarAlumnado_Desmatricular_btnConfirmar)
							.addContainerGap())))
				.addGroup(gl_pantallaModulos_GestionarAlumnado_Desmatricular.createSequentialGroup()
					.addGap(44)
					.addGroup(gl_pantallaModulos_GestionarAlumnado_Desmatricular.createParallelGroup(Alignment.LEADING)
						.addComponent(pantallaModulos_GestionarAlumnado_Desmatricular_lblModulo)
						.addComponent(pantallaModulos_GestionarAlumnado_Desmatricular_lblAlumno)
						.addGroup(gl_pantallaModulos_GestionarAlumnado_Desmatricular.createSequentialGroup()
							.addGroup(gl_pantallaModulos_GestionarAlumnado_Desmatricular.createParallelGroup(Alignment.LEADING)
								.addComponent(pantallaModulos_GestionarAlumnado_Desmatricular_lblIdentificadorAlumno)
								.addComponent(pantallaModulos_GestionarAlumnado_Desmatricular_lblIdentificadorMdulo))
							.addGap(59)
							.addGroup(gl_pantallaModulos_GestionarAlumnado_Desmatricular.createParallelGroup(Alignment.LEADING, false)
								.addComponent(pantallaModulos_GestionarAlumnado_Desmatricular_comboBoxIdModulo, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(pantallaModulos_GestionarAlumnado_Desmatricular_comboBoxIdAlumno, 0, 115, Short.MAX_VALUE))))
					.addContainerGap(287, Short.MAX_VALUE))
		);
		gl_pantallaModulos_GestionarAlumnado_Desmatricular.setVerticalGroup(
			gl_pantallaModulos_GestionarAlumnado_Desmatricular.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pantallaModulos_GestionarAlumnado_Desmatricular.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pantallaModulos_GestionarAlumnado_Desmatricular.createParallelGroup(Alignment.BASELINE)
						.addComponent(pantallaModulos_GestionarAlumnado_Desmatricular_lblDesmatricularAlumnadoEn)
						.addComponent(pantallaModulos_GestionarAlumnado_Desmatricular_btnVolver))
					.addGap(47)
					.addGroup(gl_pantallaModulos_GestionarAlumnado_Desmatricular.createParallelGroup(Alignment.BASELINE)
						.addComponent(pantallaModulos_GestionarAlumnado_Desmatricular_lblIdentificadorAlumno)
						.addComponent(pantallaModulos_GestionarAlumnado_Desmatricular_comboBoxIdAlumno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addComponent(pantallaModulos_GestionarAlumnado_Desmatricular_lblAlumno)
					.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
					.addGroup(gl_pantallaModulos_GestionarAlumnado_Desmatricular.createParallelGroup(Alignment.BASELINE)
						.addComponent(pantallaModulos_GestionarAlumnado_Desmatricular_lblIdentificadorMdulo)
						.addComponent(pantallaModulos_GestionarAlumnado_Desmatricular_comboBoxIdModulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addComponent(pantallaModulos_GestionarAlumnado_Desmatricular_lblModulo)
					.addGap(27)
					.addComponent(pantallaModulos_GestionarAlumnado_Desmatricular_btnConfirmar)
					.addContainerGap())
		);
		pantallaModulos_GestionarAlumnado_Desmatricular.setLayout(gl_pantallaModulos_GestionarAlumnado_Desmatricular);
		
		pantallaFaltas_Registrar = new JPanel();
		pantallaFaltas_Registrar.setBackground(Color.CYAN);
		panelPrincipal.add(pantallaFaltas_Registrar, "name_62726812460801");
		
		pantallaFaltas_Registrar_btnVolver = new JButton("Volver");
		pantallaFaltas_Registrar_btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout l =(CardLayout)panelPrincipal.getLayout();
				l.show(panelPrincipal,"name_20532684802118");
			}
		});
		pantallaFaltas_Registrar_btnVolver.setIcon(new ImageIcon(Principal.class.getResource("/Res/icono-volver.png")));
		pantallaFaltas_Registrar_btnVolver.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		pantallaFaltas_Registrar_lblRegistrarFaltasDe = new JLabel("Registrar Faltas de Asistencia");
		pantallaFaltas_Registrar_lblRegistrarFaltasDe.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		pantallaFaltas_Registrar_lblIdentificadorAlumnos = new JLabel("Identificador Alumnos");
		pantallaFaltas_Registrar_lblIdentificadorAlumnos.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		pantallaFaltas_Registrar_lblIdentificadorMdulos = new JLabel("Identificador M\u00F3dulos");
		pantallaFaltas_Registrar_lblIdentificadorMdulos.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		pantallaFaltas_Registrar_lblNDeHoras = new JLabel("N\u00BA de Horas");
		pantallaFaltas_Registrar_lblNDeHoras.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		final JTextField pantallaFaltas_Registrar_textFieldHoras = new JTextField();
		pantallaFaltas_Registrar_textFieldHoras.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		pantallaFaltas_Registrar_textFieldHoras.setColumns(10);
		
		final JButton pantallaFaltas_Registrar_btnConfirmar = new JButton("Confirmar");
		pantallaFaltas_Registrar_btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id_alumno = (int) pantallaFaltas_Registrar_comboBoxIdAlumno.getSelectedItem();
				int id_modulo = (int) pantallaFaltas_Registrar_comboBoxIdModulo.getSelectedItem();
				try {
					Faltas faltas = new Faltas () ;
					faltas = faltasDAO.buscarFaltasPorIdentificadores(id_alumno, id_modulo);
					int horas = 0;
					horas = faltas.getHoras();
					String horasRegistradas = pantallaFaltas_Registrar_textFieldHoras.getText();
					int horasSumar = Integer.parseInt(horasRegistradas);
					horas = horas + horasSumar;
					faltas.setHoras(horas);
					session.beginTransaction();
					session.saveOrUpdate(faltas);
					session.getTransaction().commit();
					JOptionPane.showMessageDialog(panelPrincipal, "Se ha insertado un registro en la base de datos.","Entrada de datos.",JOptionPane.INFORMATION_MESSAGE);
				} catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(panelPrincipal, "Se ha selecionado un dato incorrectamente, revise los datos.","Error entrada de datos.",JOptionPane.ERROR_MESSAGE);
				} 
			}
		});
		pantallaFaltas_Registrar_btnConfirmar.setIcon(new ImageIcon(Principal.class.getResource("/Res/alta.png")));
		pantallaFaltas_Registrar_btnConfirmar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JButton pantallaFaltas_Registrar_btnLimpiarCampos = new JButton("Limpiar Campos");
		pantallaFaltas_Registrar_btnLimpiarCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pantallaFaltas_Registrar_textFieldHoras.setText("");
			}
		});
		pantallaFaltas_Registrar_btnLimpiarCampos.setFont(new Font("Times New Roman", Font.BOLD, 12));
		pantallaFaltas_Registrar_btnLimpiarCampos.setIcon(new ImageIcon(Principal.class.getResource("/Res/limpiar.gif")));
		
		pantallaFaltas_Registrar_comboBoxIdAlumno = new JComboBox();
		pantallaFaltas_Registrar_comboBoxIdAlumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pantallaFaltas_Registrar_btnConfirmar.setEnabled(true);
				int id = (int) pantallaFaltas_Registrar_comboBoxIdAlumno.getSelectedItem();
				int id_modulo = (int) pantallaFaltas_Registrar_comboBoxIdModulo.getSelectedItem();
				try {
					Alumnos alumno = new Alumnos ();
					alumno = alumnosDAO.buscarId(id);
					if(alumno != null){
						pantallaFaltas_Registrar_lblAlumno.setText("ID: "+alumno.getId_Alumno()+" - Nombre: "+alumno.getNombre()+" - Apellidos: "+alumno.getApellido()+" - Curso: "+alumno.getCurso());
					}
					Faltas faltas = new Faltas();
					faltas = faltasDAO.buscarFaltasPorIdentificadores(id, id_modulo);
					String horas = ""+faltas.getHoras();
					if(faltas.getHoras()<0){
						JOptionPane.showMessageDialog(panelPrincipal, "Error, el alumno no se encuentra matriculado en el módulo selecionado.","Error entrada de datos.",JOptionPane.ERROR_MESSAGE);
						pantallaFaltas_Registrar_btnConfirmar.setEnabled(false);
					}
					pantallaFaltas_Registrar_textFieldHoras.setText(horas);
				} catch (NullPointerException e1) {
					int id_alumno1 = (int) pantallaFaltas_Registrar_comboBoxIdAlumno.getSelectedItem();
					int id_modulo1 = (int) pantallaFaltas_Registrar_comboBoxIdModulo.getSelectedItem();
					Faltas faltas = new Faltas();
					faltas = faltasDAO.buscarFaltasPorIdentificadores(id_alumno1, id_modulo1);
					String horas = "0";
					int horas_Horas = Integer.parseInt(horas);
					if(horas_Horas<=0){
						JOptionPane.showMessageDialog(panelPrincipal, "Error, el alumno no se encuentra matriculado en el módulo selecionado.","Error entrada de datos.",JOptionPane.ERROR_MESSAGE);
						pantallaFaltas_Registrar_btnConfirmar.setEnabled(false);
					}
					pantallaFaltas_Registrar_textFieldHoras.setText(horas);
				}
			}
		});
		pantallaFaltas_Registrar_comboBoxIdAlumno.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		pantallaFaltas_Registrar_comboBoxIdModulo = new JComboBox();
		pantallaFaltas_Registrar_comboBoxIdModulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id_modulo = (int) pantallaFaltas_Registrar_comboBoxIdModulo.getSelectedItem();
				try {
					Modulos modulos = new Modulos ();
					modulos = modulosDAO.buscarModuloPorId(id_modulo);
					pantallaFaltas_Registrar_lblModulo.setText("ID: "+modulos.getId_Modulo()+" - Nombre: "+modulos.getNombre()+" - Siglas: "+modulos.getSiglas()+" - Curso: "+modulos.getCurso()+" - Nº Horas: "+modulos.getHoras()+" - Porcentaje: "+modulos.getPorcentaje()+"%");
					List <Alumnos> alumnos = new ArrayList<Alumnos>();
					alumnos = alumnosDAO.buscarPorCurso(modulos.getCurso());
					if(alumnos != null){
						for(Alumnos a : alumnos){
							if(a != null){
								pantallaFaltas_Registrar_comboBoxIdAlumno.addItem(a.getId_Alumno());
							}
						}
					}
				} catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(panelPrincipal, "No se han encontrados alumnos del mismo curso.","Entrada de datos.",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		pantallaFaltas_Registrar_comboBoxIdModulo.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		pantallaFaltas_Registrar_lblModulo = new JLabel("");
		pantallaFaltas_Registrar_lblModulo.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		pantallaFaltas_Registrar_lblAlumno = new JLabel("");
		pantallaFaltas_Registrar_lblAlumno.setFont(new Font("Times New Roman", Font.BOLD, 12));
		GroupLayout gl_pantallaFaltas_Registrar = new GroupLayout(pantallaFaltas_Registrar);
		gl_pantallaFaltas_Registrar.setHorizontalGroup(
			gl_pantallaFaltas_Registrar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pantallaFaltas_Registrar.createSequentialGroup()
					.addContainerGap()
					.addComponent(pantallaFaltas_Registrar_btnVolver)
					.addPreferredGap(ComponentPlacement.RELATED, 306, Short.MAX_VALUE)
					.addComponent(pantallaFaltas_Registrar_lblRegistrarFaltasDe)
					.addGap(28))
				.addGroup(gl_pantallaFaltas_Registrar.createSequentialGroup()
					.addContainerGap(309, Short.MAX_VALUE)
					.addComponent(pantallaFaltas_Registrar_btnLimpiarCampos)
					.addGap(18)
					.addComponent(pantallaFaltas_Registrar_btnConfirmar)
					.addContainerGap())
				.addGroup(gl_pantallaFaltas_Registrar.createSequentialGroup()
					.addGap(42)
					.addGroup(gl_pantallaFaltas_Registrar.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pantallaFaltas_Registrar.createSequentialGroup()
							.addComponent(pantallaFaltas_Registrar_lblAlumno)
							.addContainerGap())
						.addGroup(gl_pantallaFaltas_Registrar.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_pantallaFaltas_Registrar.createSequentialGroup()
								.addComponent(pantallaFaltas_Registrar_lblNDeHoras)
								.addGap(103)
								.addComponent(pantallaFaltas_Registrar_textFieldHoras, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
							.addGroup(gl_pantallaFaltas_Registrar.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_pantallaFaltas_Registrar.createSequentialGroup()
									.addComponent(pantallaFaltas_Registrar_lblModulo)
									.addContainerGap())
								.addGroup(gl_pantallaFaltas_Registrar.createSequentialGroup()
									.addGroup(gl_pantallaFaltas_Registrar.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_pantallaFaltas_Registrar.createSequentialGroup()
											.addComponent(pantallaFaltas_Registrar_lblIdentificadorAlumnos)
											.addGap(48)
											.addComponent(pantallaFaltas_Registrar_comboBoxIdAlumno, 0, 94, Short.MAX_VALUE))
										.addGroup(gl_pantallaFaltas_Registrar.createSequentialGroup()
											.addComponent(pantallaFaltas_Registrar_lblIdentificadorMdulos)
											.addGap(48)
											.addComponent(pantallaFaltas_Registrar_comboBoxIdModulo, 0, 96, Short.MAX_VALUE)))
									.addGap(316))))))
		);
		gl_pantallaFaltas_Registrar.setVerticalGroup(
			gl_pantallaFaltas_Registrar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pantallaFaltas_Registrar.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pantallaFaltas_Registrar.createParallelGroup(Alignment.LEADING)
						.addComponent(pantallaFaltas_Registrar_lblRegistrarFaltasDe)
						.addComponent(pantallaFaltas_Registrar_btnVolver))
					.addGap(37)
					.addGroup(gl_pantallaFaltas_Registrar.createParallelGroup(Alignment.BASELINE)
						.addComponent(pantallaFaltas_Registrar_lblIdentificadorMdulos)
						.addComponent(pantallaFaltas_Registrar_comboBoxIdModulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(pantallaFaltas_Registrar_lblModulo)
					.addGap(26)
					.addGroup(gl_pantallaFaltas_Registrar.createParallelGroup(Alignment.BASELINE)
						.addComponent(pantallaFaltas_Registrar_lblIdentificadorAlumnos)
						.addComponent(pantallaFaltas_Registrar_comboBoxIdAlumno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(15)
					.addComponent(pantallaFaltas_Registrar_lblAlumno)
					.addGap(18)
					.addGroup(gl_pantallaFaltas_Registrar.createParallelGroup(Alignment.BASELINE)
						.addComponent(pantallaFaltas_Registrar_lblNDeHoras)
						.addComponent(pantallaFaltas_Registrar_textFieldHoras, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
					.addGroup(gl_pantallaFaltas_Registrar.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(pantallaFaltas_Registrar_btnLimpiarCampos, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(pantallaFaltas_Registrar_btnConfirmar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		pantallaFaltas_Registrar.setLayout(gl_pantallaFaltas_Registrar);
		
		pantallasFaltas_Modificar = new JPanel();
		pantallasFaltas_Modificar.setBackground(Color.CYAN);
		panelPrincipal.add(pantallasFaltas_Modificar, "name_62782197594107");
		
		pantallasFaltas_Modificar_btnVolver = new JButton("Volver");
		pantallasFaltas_Modificar_btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout l =(CardLayout)panelPrincipal.getLayout();
				l.show(panelPrincipal,"name_20532684802118");
			}
		});
		pantallasFaltas_Modificar_btnVolver.setIcon(new ImageIcon(Principal.class.getResource("/Res/icono-volver.png")));
		pantallasFaltas_Modificar_btnVolver.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		pantallasFaltas_Modificar_lblModificarFaltasDe = new JLabel("Modificar Faltas de Asistencia");
		pantallasFaltas_Modificar_lblModificarFaltasDe.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		pantallasFaltas_Modificar_lblIdentificadorMdulo = new JLabel("Identificador M\u00F3dulo");
		pantallasFaltas_Modificar_lblIdentificadorMdulo.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		pantallasFaltas_Modificar_comboBoxIdModulo = new JComboBox();
		pantallasFaltas_Modificar_comboBoxIdModulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id = (int) pantallasFaltas_Modificar_comboBoxIdModulo.getSelectedItem();
				Modulos modulos = new Modulos () ;
				modulos = modulosDAO.buscarModuloPorId(id);
				if(modulos != null){
					pantallasFaltas_Modificar_lblModulo.setText("ID: "+modulos.getId_Modulo()+" - Nombre: "+modulos.getNombre()+" - Siglas: "+modulos.getSiglas()+" - "+modulos.getCurso()+" - Nº Horas: "+modulos.getHoras()+" - Porcentaje: "+modulos.getPorcentaje()+"%");
				}
				List <Faltas> faltas = new ArrayList<Faltas>();
				faltas = faltasDAO.buscarFaltasModulos(id);
				if(faltas != null){
					for(Faltas f : faltas){
						if(f != null){
							FaltasId faltas_id = new FaltasId();
							faltas_id = f.getId();
							pantallasFaltas_Modificar_comboBoxIdAlumno.addItem(faltas_id.getId_Alumno());
						}
					}
				}
			}
		});
		pantallasFaltas_Modificar_comboBoxIdModulo.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		pantallasFaltas_Modificar_lblModulo = new JLabel("");
		pantallasFaltas_Modificar_lblModulo.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		pantallasFaltas_Modificar_btnConfirmar = new JButton("Confirmar");
		pantallasFaltas_Modificar_btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int id_alumno = (int) pantallasFaltas_Modificar_comboBoxIdAlumno.getSelectedItem();
					int id_modulo = (int) pantallasFaltas_Modificar_comboBoxIdModulo.getSelectedItem();
					Faltas faltas = new Faltas();
					faltas = faltasDAO.buscarFaltasPorIdentificadores(id_alumno, id_modulo);
					String valor = pantallasFaltas_Modificar_textFieldHoras.getText();
					faltas.setHoras(Integer.parseInt(valor));
					session.beginTransaction();
					session.update(faltas);
					session.getTransaction().commit();
					JOptionPane.showMessageDialog(panelPrincipal, "Se ha modificado un registros de faltas de asisntencia.","Entrada de datos.",JOptionPane.INFORMATION_MESSAGE);
					pantallasFaltas_Modificar_textFieldHoras.setText("");
				} catch (NullPointerException e) {
					JOptionPane.showMessageDialog(panelPrincipal, "Se ha seleccionado un alumno que no perteneze a este módulo profesional.","Error entrada de datos.",JOptionPane.ERROR_MESSAGE);
					pantallasFaltas_Modificar_textFieldHoras.setText("");
				} 
			}
		});
		pantallasFaltas_Modificar_btnConfirmar.setIcon(new ImageIcon(Principal.class.getResource("/Res/alta.png")));
		pantallasFaltas_Modificar_btnConfirmar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		pantallasFaltas_Modificar_lblIdentificadorAlumnos = new JLabel("Identificador Alumnos");
		pantallasFaltas_Modificar_lblIdentificadorAlumnos.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		
		pantallasFaltas_Modificar_comboBoxIdAlumno = new JComboBox();
		pantallasFaltas_Modificar_comboBoxIdAlumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id = (int) pantallasFaltas_Modificar_comboBoxIdAlumno.getSelectedItem();
				int id_modulo = (int) pantallasFaltas_Modificar_comboBoxIdModulo.getSelectedItem();
				Alumnos alumnos = new Alumnos();
				alumnos = alumnosDAO.buscarId(id);
				if(alumnos != null){
					pantallasFaltas_Modificar_lblIdAlumno.setText("ID: "+alumnos.getId_Alumno()+" - Nombre: "+alumnos.getNombre()+" - Apellidos: "+alumnos.getApellido()+" - Curso: "+alumnos.getCurso());
				}
				Faltas faltas = new Faltas ();
				faltas = faltasDAO.buscarFaltasPorIdentificadores(id, id_modulo);
				if(faltas != null){
					String horas = ""+faltas.getHoras();
					pantallasFaltas_Modificar_textFieldHoras.setText(horas);
				}
			}
		});
		pantallasFaltas_Modificar_comboBoxIdAlumno.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		pantallasFaltas_Modificar_lblIdAlumno = new JLabel("");
		pantallasFaltas_Modificar_lblIdAlumno.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		pantallasFaltas_Modificar_lblNHoras = new JLabel("N\u00BA Horas");
		pantallasFaltas_Modificar_lblNHoras.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		pantallasFaltas_Modificar_textFieldHoras = new JTextField();
		pantallasFaltas_Modificar_textFieldHoras.setColumns(10);
		GroupLayout gl_pantallasFaltas_Modificar = new GroupLayout(pantallasFaltas_Modificar);
		gl_pantallasFaltas_Modificar.setHorizontalGroup(
			gl_pantallasFaltas_Modificar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pantallasFaltas_Modificar.createSequentialGroup()
					.addContainerGap()
					.addComponent(pantallasFaltas_Modificar_btnVolver)
					.addPreferredGap(ComponentPlacement.RELATED, 309, Short.MAX_VALUE)
					.addComponent(pantallasFaltas_Modificar_lblModificarFaltasDe)
					.addGap(25))
				.addGroup(gl_pantallasFaltas_Modificar.createSequentialGroup()
					.addGap(41)
					.addGroup(gl_pantallasFaltas_Modificar.createParallelGroup(Alignment.LEADING)
						.addComponent(pantallasFaltas_Modificar_lblModulo)
						.addComponent(pantallasFaltas_Modificar_lblIdAlumno)
						.addGroup(gl_pantallasFaltas_Modificar.createSequentialGroup()
							.addGroup(gl_pantallasFaltas_Modificar.createParallelGroup(Alignment.LEADING)
								.addComponent(pantallasFaltas_Modificar_lblIdentificadorMdulo)
								.addComponent(pantallasFaltas_Modificar_lblIdentificadorAlumnos)
								.addComponent(pantallasFaltas_Modificar_lblNHoras))
							.addGap(31)
							.addGroup(gl_pantallasFaltas_Modificar.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pantallasFaltas_Modificar.createSequentialGroup()
									.addComponent(pantallasFaltas_Modificar_textFieldHoras, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 197, Short.MAX_VALUE)
									.addComponent(pantallasFaltas_Modificar_btnConfirmar))
								.addGroup(gl_pantallasFaltas_Modificar.createParallelGroup(Alignment.LEADING, false)
									.addComponent(pantallasFaltas_Modificar_comboBoxIdAlumno, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(pantallasFaltas_Modificar_comboBoxIdModulo, 0, 124, Short.MAX_VALUE)))))
					.addContainerGap())
		);
		gl_pantallasFaltas_Modificar.setVerticalGroup(
			gl_pantallasFaltas_Modificar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pantallasFaltas_Modificar.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pantallasFaltas_Modificar.createParallelGroup(Alignment.LEADING)
						.addComponent(pantallasFaltas_Modificar_lblModificarFaltasDe)
						.addComponent(pantallasFaltas_Modificar_btnVolver))
					.addGap(37)
					.addGroup(gl_pantallasFaltas_Modificar.createParallelGroup(Alignment.BASELINE)
						.addComponent(pantallasFaltas_Modificar_lblIdentificadorMdulo)
						.addComponent(pantallasFaltas_Modificar_comboBoxIdModulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addComponent(pantallasFaltas_Modificar_lblModulo)
					.addGap(35)
					.addGroup(gl_pantallasFaltas_Modificar.createParallelGroup(Alignment.BASELINE)
						.addComponent(pantallasFaltas_Modificar_lblIdentificadorAlumnos)
						.addComponent(pantallasFaltas_Modificar_comboBoxIdAlumno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
					.addGroup(gl_pantallasFaltas_Modificar.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_pantallasFaltas_Modificar.createSequentialGroup()
							.addComponent(pantallasFaltas_Modificar_lblIdAlumno)
							.addGap(60)
							.addComponent(pantallasFaltas_Modificar_btnConfirmar)
							.addContainerGap())
						.addGroup(gl_pantallasFaltas_Modificar.createSequentialGroup()
							.addGroup(gl_pantallasFaltas_Modificar.createParallelGroup(Alignment.TRAILING)
								.addComponent(pantallasFaltas_Modificar_textFieldHoras, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(pantallasFaltas_Modificar_lblNHoras))
							.addGap(60))))
		);
		pantallasFaltas_Modificar.setLayout(gl_pantallasFaltas_Modificar);
		
		pantallaFaltas_Consultar = new JPanel();
		pantallaFaltas_Consultar.setBackground(Color.CYAN);
		panelPrincipal.add(pantallaFaltas_Consultar, "name_63804416726148");
			
		pantallaFaltas_Consultar_btnVolver = new JButton("Volver");
		pantallaFaltas_Consultar_btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout l =(CardLayout)panelPrincipal.getLayout();
				l.show(panelPrincipal,"name_20532684802118");
			}
		});
		pantallaFaltas_Consultar_btnVolver.setIcon(new ImageIcon(Principal.class.getResource("/Res/icono-volver.png")));
		pantallaFaltas_Consultar_btnVolver.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		pantallaFaltas_Consultar_lblConsultarFaltasDe = new JLabel("Consultar Faltas de Asistencia");
		pantallaFaltas_Consultar_lblConsultarFaltasDe.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		final JButton pantallaFaltas_Consultar_btnConfirmar = new JButton("Comprobar");
		pantallaFaltas_Consultar_btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int id_modulo = (int) pantallaFaltas_Consultar_comboBoxModulo.getSelectedItem();
					int id_alumno = (int) pantallaFaltas_Consultar_comboBoxAlumnos.getSelectedItem();
					Modulos modulos = new Modulos();
//					List <Faltas> faltas = new ArrayList<Faltas> ();
					Faltas faltas = new Faltas();
					faltas = faltasDAO.buscarFaltasPorIdentificadores(id_alumno, id_modulo);
//					Alumnos alumnos = new Alumnos ();
					modulos = modulosDAO.buscarModuloPorId(id_modulo);
					if(modulos != null){
//						faltas = faltasDAO.buscarFaltasModulos(id_modulo);
						if(faltas != null){
//							for(Faltas f : faltas){
								int limite = modulos.getHoras()*modulos.getPorcentaje()/100;
								if(faltas.getHoras()>limite){
									JOptionPane.showMessageDialog(panelPrincipal, "El alumno ha superado el límite de asistencia permitido.","Alumno.",JOptionPane.ERROR_MESSAGE);
								}else{
									JOptionPane.showMessageDialog(panelPrincipal, "Este alumno no ha superado el límite de asistencia.","Alumno.",JOptionPane.PLAIN_MESSAGE);
								}
//							}
						}else{
							JOptionPane.showMessageDialog(panelPrincipal, "Este alumno no se ha matriculado en el módulo profesional seleccionado.","Alumno.",JOptionPane.ERROR_MESSAGE);
						}
					}else{
						JOptionPane.showMessageDialog(panelPrincipal, "Este alumno no se ha matriculado en el módulo profesional seleccionado.","Alumno.",JOptionPane.ERROR_MESSAGE);
					}
				} catch (NullPointerException e) {
					int id_modulo = (int) pantallaFaltas_Consultar_comboBoxModulo.getSelectedItem();
					Modulos modulos = new Modulos();
					List <Faltas> faltas = new ArrayList<Faltas> ();
					Alumnos alumnos = new Alumnos ();
					modulos = modulosDAO.buscarModuloPorId(id_modulo);
					if(modulos != null){
						faltas = faltasDAO.buscarFaltasModulos(id_modulo);
						if(faltas != null){
							for(Faltas f : faltas){
								int limite = modulos.getHoras()*modulos.getPorcentaje()/100;
								if(0>limite){
									JOptionPane.showMessageDialog(panelPrincipal, "Este alumno ha superado el límite de asistencia permitido.","Alumno.",JOptionPane.ERROR_MESSAGE);
								}else{
									JOptionPane.showMessageDialog(panelPrincipal, "Este alumno no ha superado el límite de asistencia.","Alumno.",JOptionPane.PLAIN_MESSAGE);
								}
							}
						}else{
							JOptionPane.showMessageDialog(panelPrincipal, "Este alumno no se ha matriculado en el módulo profesional seleccionado.","Alumno.",JOptionPane.ERROR_MESSAGE);
						}
					}else{
						JOptionPane.showMessageDialog(panelPrincipal, "Este alumno no se ha matriculado en el módulo profesional seleccionado.","Alumno.",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		pantallaFaltas_Consultar_btnConfirmar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		pantallaFaltas_Consultar_btnConfirmar.setIcon(new ImageIcon(Principal.class.getResource("/Res/alta.png")));
		
		JLabel pantallaFaltas_Consultar_lblModulo = new JLabel("Identificador M\u00F3dulo Profesional");
		pantallaFaltas_Consultar_lblModulo.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		pantallaFaltas_Consultar_comboBoxModulo = new JComboBox();
		pantallaFaltas_Consultar_comboBoxModulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int id = (int) pantallaFaltas_Consultar_comboBoxModulo.getSelectedItem();
					Modulos modulos = new Modulos ();
					modulos = modulosDAO.buscarModuloPorId(id);
					if(modulos != null){
						pantallaFaltas_Consultar_lblInfoModulo.setText("ID: "+modulos.getId_Modulo()+" - Nombre: "+modulos.getNombre()+" - Siglas: "+modulos.getSiglas()+" - Curso: "+modulos.getCurso()+" - Nº Horas: "+modulos.getHoras()+" - Porcentaje: "+modulos.getPorcentaje()+"%");
					}
					List <Faltas> faltas = new ArrayList<Faltas> () ;
					Alumnos alumnos = new Alumnos () ;
					faltas = faltasDAO.buscarFaltasModulos(id);
					if (faltas != null){
						pantallaFaltas_Consultar_btnConfirmar.setEnabled(true);
						pantallaFaltas_Consultar_comboBoxAlumnos.setEnabled(true);
						for(Faltas f : faltas){
							if (f != null){
								alumnos = f.getAlumno();
								pantallaFaltas_Consultar_comboBoxAlumnos.addItem(alumnos.getId_Alumno());
							}
						}
					}else{
						pantallaFaltas_Consultar_btnConfirmar.setEnabled(false);
						pantallaFaltas_Consultar_comboBoxAlumnos.setEnabled(false);
						JOptionPane.showMessageDialog(panelPrincipal, "Este alumno no se ha matriculado en el módulo profesional seleccionado.","Alumno.",JOptionPane.ERROR_MESSAGE);
					}
				} catch (NullPointerException e) {
					pantallaFaltas_Consultar_comboBoxAlumnos.setEnabled(false);
					JOptionPane.showMessageDialog(panelPrincipal, "Este alumno no se ha matriculado en el módulo profesional seleccionado.","Alumno.",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		pantallaFaltas_Consultar_comboBoxModulo.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		pantallaFaltas_Consultar_lblInfoModulo = new JLabel("");
		pantallaFaltas_Consultar_lblInfoModulo.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		pantallaFaltas_Consultar_comboBoxAlumnos = new JComboBox();
		pantallaFaltas_Consultar_comboBoxAlumnos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id = (int) pantallaFaltas_Consultar_comboBoxAlumnos.getSelectedItem();
				Alumnos alumnos = new Alumnos();
				alumnos = alumnosDAO.buscarId(id);
				if(alumnos != null){
					pantallaFaltas_Consultar_lblAlumno.setText("ID: "+alumnos.getId_Alumno()+" - Nombre: "+alumnos.getNombre()+" - Apellidos: "+alumnos.getApellido()+" - Curso: "+alumnos.getCurso());
				}
			}
		});
		
		JLabel pantallaFaltas_Consultar_lblIdentificadorAlumno = new JLabel("Identificador Alumno");
		pantallaFaltas_Consultar_lblIdentificadorAlumno.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		pantallaFaltas_Consultar_lblAlumno = new JLabel("");
		pantallaFaltas_Consultar_lblAlumno.setFont(new Font("Times New Roman", Font.BOLD, 12));
		GroupLayout gl_pantallaFaltas_Consultar = new GroupLayout(pantallaFaltas_Consultar);
		gl_pantallaFaltas_Consultar.setHorizontalGroup(
			gl_pantallaFaltas_Consultar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pantallaFaltas_Consultar.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pantallaFaltas_Consultar.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_pantallaFaltas_Consultar.createSequentialGroup()
							.addComponent(pantallaFaltas_Consultar_btnVolver)
							.addPreferredGap(ComponentPlacement.RELATED, 307, Short.MAX_VALUE)
							.addComponent(pantallaFaltas_Consultar_lblConsultarFaltasDe)
							.addGap(24))
						.addGroup(gl_pantallaFaltas_Consultar.createSequentialGroup()
							.addComponent(pantallaFaltas_Consultar_btnConfirmar)
							.addContainerGap())))
				.addGroup(gl_pantallaFaltas_Consultar.createSequentialGroup()
					.addGap(42)
					.addGroup(gl_pantallaFaltas_Consultar.createParallelGroup(Alignment.LEADING)
						.addComponent(pantallaFaltas_Consultar_lblAlumno)
						.addComponent(pantallaFaltas_Consultar_lblInfoModulo)
						.addGroup(gl_pantallaFaltas_Consultar.createSequentialGroup()
							.addGroup(gl_pantallaFaltas_Consultar.createParallelGroup(Alignment.LEADING)
								.addComponent(pantallaFaltas_Consultar_lblModulo)
								.addComponent(pantallaFaltas_Consultar_lblIdentificadorAlumno))
							.addGap(53)
							.addGroup(gl_pantallaFaltas_Consultar.createParallelGroup(Alignment.LEADING, false)
								.addComponent(pantallaFaltas_Consultar_comboBoxAlumnos, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(pantallaFaltas_Consultar_comboBoxModulo, 0, 110, Short.MAX_VALUE))))
					.addContainerGap(239, Short.MAX_VALUE))
		);
		gl_pantallaFaltas_Consultar.setVerticalGroup(
			gl_pantallaFaltas_Consultar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pantallaFaltas_Consultar.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pantallaFaltas_Consultar.createParallelGroup(Alignment.LEADING)
						.addComponent(pantallaFaltas_Consultar_lblConsultarFaltasDe)
						.addComponent(pantallaFaltas_Consultar_btnVolver))
					.addGap(35)
					.addGroup(gl_pantallaFaltas_Consultar.createParallelGroup(Alignment.BASELINE)
						.addComponent(pantallaFaltas_Consultar_lblModulo)
						.addComponent(pantallaFaltas_Consultar_comboBoxModulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addComponent(pantallaFaltas_Consultar_lblInfoModulo)
					.addGap(44)
					.addGroup(gl_pantallaFaltas_Consultar.createParallelGroup(Alignment.BASELINE)
						.addComponent(pantallaFaltas_Consultar_comboBoxAlumnos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(pantallaFaltas_Consultar_lblIdentificadorAlumno))
					.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
					.addComponent(pantallaFaltas_Consultar_lblAlumno)
					.addGap(34)
					.addComponent(pantallaFaltas_Consultar_btnConfirmar)
					.addContainerGap())
		);
		pantallaFaltas_Consultar.setLayout(gl_pantallaFaltas_Consultar);
		
		pantallaFaltas_Imprimir = new JPanel();
		pantallaFaltas_Imprimir.setBackground(Color.CYAN);
		panelPrincipal.add(pantallaFaltas_Imprimir, "name_64202045247091");
		
		pantallaFaltas_Imprimir_lblImprimirFaltasDe = new JLabel("Imprimir Faltas de Asistencia");
		pantallaFaltas_Imprimir_lblImprimirFaltasDe.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		pantallaFaltas_Imprimir_btnVolver = new JButton("Volver");
		pantallaFaltas_Imprimir_btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout l =(CardLayout)panelPrincipal.getLayout();
				l.show(panelPrincipal,"name_20532684802118");
			}
		});
		pantallaFaltas_Imprimir_btnVolver.setIcon(new ImageIcon(Principal.class.getResource("/Res/icono-volver.png")));
		pantallaFaltas_Imprimir_btnVolver.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		pantallaFaltas_Imprimir_btnImprimir = new JButton("Imprimir");
		pantallaFaltas_Imprimir_btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Modulos modulos = new Modulos();
			int id_modulo = (int) pantallaFaltas_Imprimir_comboBoxModulo.getSelectedItem();
			int parametro1 = (int) pantallaFaltas_Imprimir_comboBoxModulo.getSelectedItem();
			String parametro2 = getClass().getResource("../Images/fondo.jpg").getPath();
			modulos = modulosDAO.buscarModuloPorId(id_modulo);
			String parametro3 = modulos.getNombre();
			ReportView report = new ReportView();
			HashMap<String,Object> parametros = new HashMap <String, Object>();
			parametros.put("idModulo", parametro1);
			parametros.put("rutaImagen", parametro2);
			parametros.put("nombreM", parametro3);
			report.abrirReportBD(getClass().getResource("../Resource/report.jasper").getPath(), "proyectodam", parametros);
			}
		});
		pantallaFaltas_Imprimir_btnImprimir.setIcon(new ImageIcon(Principal.class.getResource("/Res/impresion.png")));
		pantallaFaltas_Imprimir_btnImprimir.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		pantallaFaltas_Imprimir_comboBoxModulo = new JComboBox();
		pantallaFaltas_Imprimir_comboBoxModulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id_modulo = (int) pantallaFaltas_Imprimir_comboBoxModulo.getSelectedItem();
				Modulos modulos = new Modulos();
				modulos = modulosDAO.buscarModuloPorId(id_modulo);
				if(modulos != null){
					pantallaFaltas_Imprimir_lblModulo.setText("ID: "+modulos.getId_Modulo()+" - Nombre: "+modulos.getNombre()+" - Siglas: "+modulos.getSiglas()+" - Curso: "+modulos.getCurso()+" - Nº Horas: "+modulos.getHoras()+" - Porcentaje: "+modulos.getPorcentaje()+"%");
				}
			}
		});
		pantallaFaltas_Imprimir_comboBoxModulo.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		lblIdentificadorMdulo = new JLabel("Identificador M\u00F3dulo");
		lblIdentificadorMdulo.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		pantallaFaltas_Imprimir_lblModulo = new JLabel("");
		pantallaFaltas_Imprimir_lblModulo.setFont(new Font("Times New Roman", Font.BOLD, 12));
		GroupLayout gl_pantallaFaltas_Imprimir = new GroupLayout(pantallaFaltas_Imprimir);
		gl_pantallaFaltas_Imprimir.setHorizontalGroup(
			gl_pantallaFaltas_Imprimir.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pantallaFaltas_Imprimir.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pantallaFaltas_Imprimir.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_pantallaFaltas_Imprimir.createSequentialGroup()
							.addComponent(pantallaFaltas_Imprimir_btnVolver)
							.addPreferredGap(ComponentPlacement.RELATED, 309, Short.MAX_VALUE)
							.addComponent(pantallaFaltas_Imprimir_lblImprimirFaltasDe)
							.addGap(26))
						.addGroup(gl_pantallaFaltas_Imprimir.createSequentialGroup()
							.addComponent(pantallaFaltas_Imprimir_btnImprimir)
							.addContainerGap())))
				.addGroup(gl_pantallaFaltas_Imprimir.createSequentialGroup()
					.addGap(65)
					.addComponent(lblIdentificadorMdulo)
					.addGap(82)
					.addComponent(pantallaFaltas_Imprimir_comboBoxModulo, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(192, Short.MAX_VALUE))
				.addGroup(gl_pantallaFaltas_Imprimir.createSequentialGroup()
					.addGap(46)
					.addComponent(pantallaFaltas_Imprimir_lblModulo)
					.addContainerGap(525, Short.MAX_VALUE))
		);
		gl_pantallaFaltas_Imprimir.setVerticalGroup(
			gl_pantallaFaltas_Imprimir.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pantallaFaltas_Imprimir.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pantallaFaltas_Imprimir.createParallelGroup(Alignment.BASELINE)
						.addComponent(pantallaFaltas_Imprimir_lblImprimirFaltasDe)
						.addComponent(pantallaFaltas_Imprimir_btnVolver))
					.addGap(39)
					.addGroup(gl_pantallaFaltas_Imprimir.createParallelGroup(Alignment.BASELINE)
						.addComponent(pantallaFaltas_Imprimir_comboBoxModulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblIdentificadorMdulo))
					.addGap(43)
					.addComponent(pantallaFaltas_Imprimir_lblModulo)
					.addPreferredGap(ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
					.addComponent(pantallaFaltas_Imprimir_btnImprimir, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		pantallaFaltas_Imprimir.setLayout(gl_pantallaFaltas_Imprimir);
		cargarAyuda();
	}
	
	/**
	 * Cargar ayuda
	 */
	public void cargarAyuda() {
		
		URL hsURL;
		
		try {
			
			// Carga el fichero de ayuda
			File fichero = new File("help/help_set.hs");
			hsURL = fichero.toURI().toURL();
			
			// Crea el HelpSet
			HelpSet helpset = new HelpSet(getClass().getClassLoader(), hsURL);
			
			HelpBroker hb = helpset.createHelpBroker();
			
			// Ayuda al hacer click en el JMenuItem itemAyuda.
			hb.enableHelpOnButton(mntmAyuda, "aplicacion", helpset);
			
			// Ayuda al pulsar F1 sobre la ventana principal
			hb.enableHelpKey(this.getContentPane(), "aplicacion",helpset);

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HelpSetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param id, recibe como paramtros el identificador del alumno
	 * @param session, recibe como parametros el objeto Session
	 * @return, devuelve un alumno
	 */
	public Alumnos buscarId (int id, Session session){
		Alumnos alumno = (Alumnos) session.get(Alumnos.class, id);
		return alumno;
	}
}

