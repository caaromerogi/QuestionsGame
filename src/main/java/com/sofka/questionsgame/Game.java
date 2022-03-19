package com.sofka.questionsgame;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends javax.swing.JFrame {

    //Inicializar jugador
    Player p1;

    //Inicializar nivel de dificultad en 1
    int difficultyLevel = 1;

    Question q1 = new Question("¿Quién descubrió América?", "Cristobal Colón", "Jesucristo", "Julio Cesar", "Raphael");
    Question q2 = new Question("¿Qué compositor sufría de sordera?", "Beethoven", "Mozart", "Wagner", "Vivaldi");
    Question q3 = new Question("¿Quién pintó la monalisa?", "DaVinci", "Raphael", "Picasso", "Monet");
    Question q4 = new Question("¿Qué pintor se cortó una de sus orejas?", "Van Gogh", "Velasquez", "Renoir", "Manet");
    Question q5 = new Question("¿Quién escribió 100 años de soledad?", "Gabriel García", "Jorge Isaacs", "Pablo Neruda", "Edgar Allan Poe");

    Question q6 = new Question("¿Cuánto es 2x2?", "4", "6", "24", "30");
    Question q7 = new Question("La raiz cuadrada de 81 es...", "9", "15", "40", "7");
    Question q8 = new Question("El logaritmo natural de 0 es...", "1", "No está definido", "+Infinito", "-Infinito");
    Question q9 = new Question("El valor de pi es aproximadamente...", "3.14", "2.13", "1.42", "5.55");
    Question q10 = new Question("El valor absoluto de -5 es...", "5", "-5", "No tiene", "0");

    Question q11 = new Question("¿Cuál animal es endémico de Colombia?", "Tití gris", "Chimpancé", "Gorila", "Orangutan");
    Question q12 = new Question("¿Cuál es el animal marino que alcanza mayor velocidad?", "Marlin negro", "Delfín", "Caballito de mar", "Camarón pistola");
    Question q13 = new Question("¿Cuál es el animal más lento del mundo?", "Perezoso", "Tortuga", "Lombriz", "Camarón");
    Question q14 = new Question("¿Cuál de estos animales no necesita agua para vivir?", "Rata canguro", "Camello", "Caballo", "Perro");
    Question q15 = new Question("¿De qué parte de América es nativo el Condor", "Suramerica", "Norteamérica", "Centroamérica", "No es de América");

    Question q16 = new Question("¿Quién formuló la teoría de la relatividad general?", "Einstein", "Galilep", "Kepler", "Tesla");
    Question q17 = new Question("¿Quién fue el inventor de la dimaita?", "Alfred Nobel", "Daniel Dynamesk", "Henry Ford", "Xin Hai");
    Question q18 = new Question("¿Cuántas leyes de Mendel existen?", "3", "2", "5", "10");
    Question q19 = new Question("Una de las siguientes NO pertence a las bases del ADN", "Melanina", "Citosina", "Adenina", "Timina");
    Question q20 = new Question("La velocidad de la luz es aproximadamente...", "300.000 km/s", "300.000km/h", "500.000km/s", "500.000km/h");

    Question q21 = new Question("¿Cuál fue el primer país en aprobar el sufragio femenino?", "Nueva Zelanda", "USA", "Alemania", "Reino Unido");
    Question q22 = new Question("¿En qué año se llevó a cabo la battalla de Waterloo?", "1815", "1802", "1916", "1945");
    Question q23 = new Question("¿Qué reinta Británica fue hija de los Reyes Católicos", "Catalina de Aragón", "Juana de Arco", "Juana la loca", "Isabel I");
    Question q24 = new Question("¿De qué país se independizó Eslovenia?", "Yugoslavia", "Eslovaquia", "Polonia", "Hungría");
    Question q25 = new Question("¿En qué año tuvo lugar el genocidio de Ruanda?", "1994", "1914", "1491", "1991");

    //Instanciar categorias con su dificultad
    Category maths = new Category(1);
    Category arte = new Category(2);
    Category animals = new Category(3);
    Category science = new Category(4);
    Category history = new Category(5);

    //Instanciar arraylist de categorias
    ArrayList<Category> categorias = new ArrayList<Category>();

    //Declarar la rond
    Round ronda;

    //Declarar variable para almacenar pregunta aleatoria
    Question randomQuestion;

    //Declarar conector
    Connector con = new Connector();

    public Game() {
        initComponentsStart();
        //Añadir categorias al array de categorias
        maths.addQuestions(q6, q7, q8, q9, q10);
        arte.addQuestions(q1, q2, q3, q4, q5);
        animals.addQuestions(q11, q12, q13, q14, q15);
        science.addQuestions(q16, q17, q18, q19, q20);
        history.addQuestions(q21, q22, q23, q24, q25);

        //Agregar las categorias a la lista de categorias
        categorias.add(arte);
        categorias.add(maths);
        categorias.add(animals);
        categorias.add(science);
        categorias.add(history);

    }

    public static void main(String[] args) {
        new Game().setVisible(true);
    }

    public void initComponentsStart() {
        jPanel1 = new JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("¡BIENVENIDO AL JUEGO!");

        jLabel2.setText("Ingresa tu nombre para empezar");

        jButton1.setText("Comenzar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(jLabel2)
                                .addGap(52, 52, 52)
                                .addComponent(jTextField1)
                                .addGap(51, 51, 51))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(168, 168, 168)
                                                .addComponent(jLabel1))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(229, 229, 229)
                                                .addComponent(jButton1)))
                                .addContainerGap(188, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jLabel1)
                                .addGap(52, 52, 52)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(99, 99, 99)
                                .addComponent(jButton1)
                                .addContainerGap(102, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    public void initComponentsInGame() {
        //pregunta random generada en la ronda
        randomQuestion = ronda.getRandomQuestion();

        //Array con las opciones de respuesta
        ArrayList<String> options = randomQuestion.getOptions();

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        //Apartado gráfico
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Jugador:");

        jLabel4.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText(p1.getName());

        jLabel5.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel5.setText("Acumulado:");

        jLabel6.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel6.setText(String.valueOf(p1.getAccumulatedPrize()));

        jLabel7.setFont(new java.awt.Font("Microsoft Tai Le", 2, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText(randomQuestion.getStatement());

        jLabel8.setFont(new java.awt.Font("Microsoft Tai Le", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText(options.get(0));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Microsoft Tai Le", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText(options.get(1));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Microsoft Tai Le", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText(options.get(2));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Microsoft Tai Le", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText(options.get(3));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Microsoft Tai Le", 0, 18)); // NOI18N
        jLabel12.setText("¡Selecciona una respuesta!");

        jButton2.setText("Retirarse");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(101, 101, 101))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2)
                                .addGap(223, 223, 223))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addGap(144, 144, 144)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(23, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(19, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(156, 156, 156))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6))
                                .addGap(56, 56, 56)
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                .addComponent(jButton2)
                                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    public void initComponentsLose() {
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel13.setFont(new java.awt.Font("Microsoft Tai Le", 0, 18)); // NOI18N
        jLabel13.setText("HAS PERDIDO :(");

        jLabel14.setText("Esta vez no te llevas nada a casa, pero puedes seguir intentando");

        jButton3.setText("Jugar de nuevo");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jButton4.setText("Histórico");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });;

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(127, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel13)
                                                .addGap(198, 198, 198))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel14)
                                                .addGap(95, 95, 95))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addComponent(jButton3)
                                .addGap(92, 92, 92)
                                .addComponent(jButton4)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jLabel13)
                                .addGap(43, 43, 43)
                                .addComponent(jLabel14)
                                .addGap(53, 53, 53)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton3)
                                        .addComponent(jButton4))
                                .addContainerGap(74, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    public void initComponentsWin() {

    }

    public void initComponentsSurrender() {

    }

    public void initComponetsScore() {

    }

//Eventos de clickeo
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {
        //Instanciar jugador
        p1 = new Player(jTextField1.getText());
        //Instanciar la ronda
        ronda = new Round(categorias, difficultyLevel, p1);
        //Remover los objetos del panel para hacer una nueva pantalla
        jPanel1.removeAll();
        jPanel1.repaint();
        //Inicializar los nuevos componentes gráficos
        initComponentsInGame();
    }

//Clickear en una opción de respuesta
    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {
        //Si la pregunta seleccionada es la respuesta correcta...
        if (jLabel8.getText().equals(randomQuestion.getRightAnswer())) {
            nextRound();
        } else {
            //Remueve elementos gráficos para iniciar una pantalla con nueva pregunta
            jPanel1.removeAll();
            jPanel1.repaint();
            //Jugador pierde premio
            p1.losePrize();
            con.savePlayer(p1);
            //Se muestra la pantalla de "perdiste"
            initComponentsLose();
        }

    }

//Clickear en una opción de respuesta
    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {
        //Si la pregunta seleccionada es la respuesta correcta...
        if (jLabel9.getText().equals(randomQuestion.getRightAnswer())) {
            //Sube de nivel, otorga premio y pasa a nueva pregunta
            nextRound();
        } else {
            //Quita el acumulado al jugador, muestra pantalla de perdiste y guarda el resultado
            youLose();
        }
    }

//Clickear en una opción de respuesta
    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {
        //Si la pregunta seleccionada es la respuesta correcta...
        if (jLabel10.getText().equals(randomQuestion.getRightAnswer())) {
            //Sube de nivel, otorga premio y pasa a nueva pregunta
            nextRound();
        } else {
            //Quita el acumulado al jugador, muestra pantalla de perdiste y guarda el resultado
            youLose();
        }
    }

//Clickear en una opción de respuesta
    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {
        //Si la pregunta seleccionada es la respuesta correcta...
        if (jLabel11.getText().equals(randomQuestion.getRightAnswer())) {
            //Sube de nivel, otorga premio y pasa a nueva pregunta
            nextRound();
        } else {
            //Quita el acumulado al jugador, muestra pantalla de perdiste y guarda el resultado
            youLose();
        }
    }

    //verificar si el jugador superó el max nivel de dificultad
    public void verifyWin() {
        if (ronda.currentLevel() == 6) {
            //agregar pantalla de victoria;
        } else {
            initComponentsInGame();
        }

    }

    public void nextRound() {
        //Otorga premio al jugador
        p1.increaseAccumulated(ronda.getPrize());
        //Sube de nivel
        ronda.levelUp();
        //Remueve elementos gráficos para iniciar una pantalla con nueva pregunta
        jPanel1.removeAll();
        jPanel1.repaint();

        //Inicia la nueva pantalla de preguntas o de victoria dado que gane
        verifyWin();
    }

    public void youLose() {
        //Remueve elementos gráficos para iniciar una pantalla con nueva pregunta
        jPanel1.removeAll();
        jPanel1.repaint();
        //Jugador pierde premio
        p1.losePrize();
        con.savePlayer(p1);
        //Se muestra la pantalla de "perdiste"
        initComponentsLose();
    }

    //Retirarse
    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {

    }

//CLickear botón "Jugar de nuevo"
    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {
        Boolean newGame = true;
        jPanel1.removeAll();
        jPanel1.repaint();
        //sobrecargar el método para escribir sobre el JPanel1 otra vez
        initComponentsStart();

    }

//Clickear botón "Histórico"
    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {

    }

//Variables gráficas
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;

}
