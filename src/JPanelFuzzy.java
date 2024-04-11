import javax.swing.JSlider;
import javax.swing.SwingConstants;

import java.io.InputStream;

import javax.swing.JLabel;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JDialogFis;



public class JPanelFuzzy extends javax.swing.JFrame {
    // Para rodar o .jar
    // InputStream fileName = getClass().getResourceAsStream("Trabalho.fcl");

    // Para rodar no VSCODE
    String fileName = "./src/Trabalho.fcl";
    FIS fis; 
    JDialogFis dialogoFIS;
    private double taxaIrrigacao;



    public JPanelFuzzy() {
        initComponents();
        
        jSliderUmidadeSolo.setValue(50);
        jSliderUmidadeAr.setValue(50);
        jSliderTemperatura.setValue(25);
        jSliderTamanhoEstufa.setValue(20);

        fis = FIS.load(fileName, true);
        if (fis == null) {
            System.err.println("Erro ao carregar o arquivo FCL: " + fileName);
            return;
        }

        dialogoFIS = new JDialogFis(fis);

        runCode();
    }

    public void runCode() {
        if (fis == null) {
            System.err.println("FIS não inicializado corretamente.");
            return;
        }

        fis.setVariable("umidade_do_solo", jSliderUmidadeSolo.getValue());
        jLabelUmidadeSolo.setText("Umidade do Solo: " + jSliderUmidadeSolo.getValue() + "%");

        fis.setVariable("umidade_relativa_do_ar", jSliderUmidadeAr.getValue());
        jLabelUmidadeAr.setText("Umidade Relativa do Ar: " + jSliderUmidadeAr.getValue() + "%");

        fis.setVariable("temperatura", jSliderTemperatura.getValue());
        jLabelTemperatura.setText("Temperatura: " + jSliderTemperatura.getValue() + " °C");
        
        fis.setVariable("tamanho_da_estufa", jSliderTamanhoEstufa.getValue());
        jLabelTamanhoEstufa.setText("Tamanho da Estufa: " + jSliderTamanhoEstufa.getValue() + " m²");

        fis.evaluate();

        taxaIrrigacao = fis.getVariable("taxa_de_irrigacao").getLatestDefuzzifiedValue();
        jLabelTaxaIrrigacao.setText("Taxa de Irrigação: " + taxaIrrigacao + "%");

        dialogoFIS.repaint();
    }
    

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jSliderUmidadeSolo = new javax.swing.JSlider();
        jSliderUmidadeAr = new javax.swing.JSlider();
        jSliderTemperatura = new javax.swing.JSlider();
        jSliderTamanhoEstufa = new javax.swing.JSlider();
        jLabelUmidadeSolo = new JLabel("Umidade do Solo");
        jLabelUmidadeAr = new JLabel("Umidade Relativa do Ar");
        jLabelTemperatura = new JLabel("Temperatura");
        jLabelTamanhoEstufa = new JLabel("Tamanho da Estufa");
        jLabelTaxaIrrigacao = new JLabel("Taxa de Irrigação: ");
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSliderUmidadeSolo.setMinimum(0);
        jSliderUmidadeSolo.setMaximum(100);
        jSliderUmidadeSolo.setPaintTicks(true);

        jSliderUmidadeAr.setMinimum(0);
        jSliderUmidadeAr.setMaximum(100);
        jSliderUmidadeAr.setPaintTicks(true);

        jSliderTemperatura.setMinimum(-5);
        jSliderTemperatura.setMaximum(32);
        jSliderTemperatura.setPaintTicks(true);

        jSliderTamanhoEstufa.setMinimum(5);
        jSliderTamanhoEstufa.setMaximum(50);
        jSliderTamanhoEstufa.setPaintTicks(true);

        jSliderUmidadeSolo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderChanged(evt);
            }
        });

        jSliderUmidadeAr.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderChanged(evt);
            }
        });

        jSliderTemperatura.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderChanged(evt);
            }
        });

        jSliderTamanhoEstufa.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderChanged(evt);
            }
        });
        

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelUmidadeSolo)
                        .addComponent(jSliderUmidadeSolo, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                        .addComponent(jLabelUmidadeAr)
                        .addComponent(jSliderUmidadeAr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelTemperatura)
                        .addComponent(jSliderTemperatura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelTamanhoEstufa)
                        .addComponent(jSliderTamanhoEstufa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelTaxaIrrigacao)
                    )
                    .addContainerGap()
                )
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabelUmidadeSolo)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)

                    .addComponent(jSliderUmidadeSolo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)

                    .addComponent(jLabelUmidadeAr)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)

                    .addComponent(jSliderUmidadeAr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)

                    .addComponent(jLabelTemperatura)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)

                    .addComponent(jSliderTemperatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)

                    .addComponent(jLabelTamanhoEstufa)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)

                    .addComponent(jSliderTamanhoEstufa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)

                    .addComponent(jLabelTaxaIrrigacao)

                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                )
        );
        pack();
    }

    private void jSliderChanged(javax.swing.event.ChangeEvent evt) {
        runCode();
    }


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JPanelFuzzy().setVisible(true);
            }
        });
    }


    private JSlider jSliderUmidadeSolo;
    private JSlider jSliderUmidadeAr;
    private JSlider jSliderTemperatura;
    private JSlider jSliderTamanhoEstufa;
    private JLabel jLabelUmidadeSolo;
    private JLabel jLabelUmidadeAr;
    private JLabel jLabelTemperatura;
    private JLabel jLabelTamanhoEstufa;
    private JLabel jLabelTaxaIrrigacao;
}
