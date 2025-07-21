package com.kauan.trabalho.fisica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrabalhoFisica extends JFrame {

    // Constante eletrostática padrão (Nm²/C²)
    static final double KE_PADRAO = 8.99e9;

    // Campos de entrada do usuário
    private JTextField campoCarga;       // Campo para carga (fC)
    private JTextField campoDistancia;   // Campo para distância (cm)
    private JTextField campoK;           // Campo opcional para constante k
    private JLabel resultadoLabel;       // Rótulo onde aparece o resultado final

    // Construtor da interface gráfica
    public TrabalhoFisica() {
        super("Calculadora de Potencial Elétrico");

        // Painel principal com layout vertical e espaçamento interno
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        // Painel para o campo de carga
        JPanel painelCarga = new JPanel(new FlowLayout(FlowLayout.LEFT));
        painelCarga.add(new JLabel("Carga (fC):")); // Rótulo
        campoCarga = new JTextField(10);            // Campo de texto
        painelCarga.add(campoCarga);                // Adiciona o campo ao painel

        // Painel para o campo de distância
        JPanel painelDistancia = new JPanel(new FlowLayout(FlowLayout.LEFT));
        painelDistancia.add(new JLabel("Distância (cm):"));
        campoDistancia = new JTextField(10);
        painelDistancia.add(campoDistancia);

        // Painel para o campo da constante k (opcional)
        JPanel painelK = new JPanel(new FlowLayout(FlowLayout.LEFT));
        painelK.add(new JLabel("Constante k (opcional, padrão 8.99e9):"));
        campoK = new JTextField(10);
        painelK.add(campoK);

        // Criação dos botões
        JButton botaoCalcular = new JButton("Calcular Potencial");
        JButton botaoReiniciar = new JButton("Reiniciar");

        // Estilo dos botões
        Font fonteBotao = new Font("SansSerif", Font.BOLD, 14);
        botaoCalcular.setFocusPainted(false);
        botaoCalcular.setFont(fonteBotao);
        botaoCalcular.setBackground(new Color(70, 130, 180)); // Azul
        botaoCalcular.setForeground(Color.WHITE);

        botaoReiniciar.setFocusPainted(false);
        botaoReiniciar.setFont(fonteBotao);
        botaoReiniciar.setBackground(new Color(220, 20, 60)); // Vermelho
        botaoReiniciar.setForeground(Color.WHITE);

        // Painel com os botões centralizados
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER));
        painelBotoes.add(botaoCalcular);
        painelBotoes.add(botaoReiniciar);

        // Campo para exibir o resultado final
        resultadoLabel = new JLabel("Resultado: ");
        resultadoLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        resultadoLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Painel do resultado
        JPanel painelResultado = new JPanel(new FlowLayout(FlowLayout.CENTER));
        painelResultado.add(resultadoLabel);

        // Adiciona todos os painéis ao painel principal
        painelPrincipal.add(painelCarga);
        painelPrincipal.add(painelDistancia);
        painelPrincipal.add(painelK);
        painelPrincipal.add(painelBotoes);
        painelPrincipal.add(painelResultado);

        // Configurações finais da janela
        add(painelPrincipal);
        setSize(500, 320);               // Tamanho da janela
        setResizable(false);             // Não permite redimensionar
        setLocationRelativeTo(null);     // Centraliza a janela na tela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha o app ao clicar no X

        // Ação ao clicar em "Calcular"
        botaoCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularPotencial(); // Chama a função que faz o cálculo
            }
        });

        // Ação ao clicar em "Reiniciar"
        botaoReiniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Limpa os campos de entrada e o resultado
                campoCarga.setText("");
                campoDistancia.setText("");
                campoK.setText("");
                resultadoLabel.setText("Resultado: ");
            }
        });
    }

    // Função principal que realiza o cálculo do potencial
    private void calcularPotencial() {
        try {
            // Pega os valores digitados pelo usuário
            double qInput = Double.parseDouble(campoCarga.getText());
            double dInput = Double.parseDouble(campoDistancia.getText());

            // Verifica se os valores são válidos (positivos)
            if (qInput <= 0 || dInput <= 0) {
                resultadoLabel.setText("Erro: Carga e distância devem ser maiores que zero.");
                return;
            }

            // Converte os valores para unidades do SI:
            double q = qInput * 1e-15;   // Converte fC para C
            double d = dInput / 100.0;   // Converte cm para m

            // Verifica se o usuário digitou a constante k
            double k;
            String kText = campoK.getText().trim();
            if (kText.isEmpty()) {
                k = KE_PADRAO; // Se não digitou nada, usa o padrão
            } else {
                k = Double.parseDouble(kText);
                if (k < 1e8 || k > 1e12) {
                    resultadoLabel.setText("Erro: k deve estar entre 1e8 e 1e12 Nm²/C².");
                    return;
                }
            }

            // Calcula os potenciais parciais:
            double v1 = k * q / d;         // Potencial de carga a d
            double v2 = k * q / (2 * d);   // Potencial de carga a 2d

            // Potencial total no ponto P: 2*v1 - v1 - v2
            double Vtotal = 2 * v1 - v1 - v2;

            // Exibe o resultado com notação científica
            resultadoLabel.setText(String.format("Potencial em P: %.3e volts", Vtotal));

        } catch (NumberFormatException ex) {
            // Caso o usuário digite letras ou símbolos
            resultadoLabel.setText("Erro: Insira apenas números válidos.");
        }
    }

    // Função principal: cria a janela e a exibe
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TrabalhoFisica janela = new TrabalhoFisica();
            janela.setVisible(true);
        });
    }
}
