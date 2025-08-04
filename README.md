# 🧮 Calculadora de Potencial Elétrico em Java (Swing)

Uma calculadora feita em Java com interface gráfica (JFrame), desenvolvida para resolver um problema clássico de física eletrostática: o cálculo do **potencial elétrico no ponto P**, gerado por **quatro cargas pontuais**.

## 📘 Sobre o problema

A calculadora é baseada em um exercício do livro de Física, onde são dadas quatro partículas com cargas `+q` e `-q`, dispostas simetricamente ao redor de um ponto `P`. O programa calcula o potencial elétrico no ponto `P`, considerando:

- Distância entre as cargas e o ponto `P`
- Valor da carga `q`
- A constante eletrostática `K` (com valor padrão de `8.99 × 10⁹ N·m²/C²`, mas editável)

📐 Fórmula usada:

**V = k × Σ (qᵢ / rᵢ)**

---

## 🖼️ Imagem do exercício

<img width="783" height="530" alt="image" src="https://github.com/user-attachments/assets/09f285a7-f76d-4014-a603-c162441fbdb3" />

---

## 🖼️ Preview da Interface

<img width="480" height="305" alt="image" src="https://github.com/user-attachments/assets/bb775221-ecaa-4349-82bd-0530f9f7973f" />

---

## ⚙️ Funcionalidades

✅ Interface gráfica (Swing)  
✅ Validação de todas as entradas do usuário  
✅ Constante `K` personalizável (opcional)  
✅ Cálculo dinâmico do potencial no ponto `P`  
✅ Botões para **calcular** e **limpar/reiniciar** a interface  
✅ Interface centralizada e responsiva  
✅ Totalmente comentado para fins educacionais  

---

## 🧪 Como usar

1. Insira o valor da carga `q` (em **fC** — femtocoulombs).
2. Insira a distância `d` (em **cm**).
3. (Opcional) Insira a constante eletrostática `K` (em **N·m²/C²**). Deixe em branco para usar o valor padrão.
4. Clique em **"Calcular"** para ver o potencial no ponto `P`.
5. Clique em **"Limpar"** para reiniciar os campos.

---

## 🛠️ Tecnologias usadas

- Java SE
- Swing (javax.swing)
- Validação e formatação de entrada com Java padrão

---

## 📁 Organização do Código

- Entradas com validação numérica (sem negativos, não-vazios obrigatórios)
- Área de resultado em tempo real
- Comentários detalhados em todo o código explicando cada passo (fórmulas, variáveis, verificações etc.)

---

## 🧠 Conceitos de Física usados

- Potencial elétrico de uma carga pontual
- Superposição de potenciais
- Constante de Coulomb
- Conversão de unidades: **fC → C**, **cm → m**

---


## 🚀 Como rodar o projeto

Compile com `javac CalculadoraPotencial.java`  
Execute com `java CalculadoraPotencial`

> É necessário ter o Java instalado na máquina (JDK 8 ou superior).
