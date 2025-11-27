# 🧬 Conway's Game of Life (GOL) Simulator

This project is a graphical implementation of **Conway's Game of Life**, a zero-player cellular automaton devised by mathematician John Horton Conway. The simulation is built using Java Swing for the graphical user interface (GUI) and follows a basic Model-View-Controller (MVC) architectural pattern.

## ✨ Features

* **Dynamic Grid:** Simulates the cellular automaton on a configurable grid size.
* **Interactive Setup:** Users can toggle individual cells (make them 'Alive' or 'Dead') by clicking on them before the simulation starts.
* **Simulation Control:** Includes buttons for starting/stopping the automatic progression, stepping through generations manually, and clearing the entire world.
* **Speed Control:** Buttons to increase and decrease the simulation speed (generation interval).
* **Generation Counter:** Displays the current generation number.

## 📐 Project Structure

The project is logically divided into three primary Java classes:

| Class | Role | Description |
| :--- | :--- | :--- |
| **`GOLMatrix.java`** | **Model (Logic)** | Manages the state of the world grid (`boolean[][] world`), calculates the next generation based on GOL rules, and tracks the generation count. |
| **`GOLPanel.java`** | **View/Controller** | Extends `JPanel`. Handles the GUI elements (buttons, grid), manages user input (clicks), and controls the `Timer` loop to update the simulation. |
| **`Main.java`** | **Bootstrap** | Contains the `main` method to initialize the `JFrame` and instantiate the `GOLPanel`. |

## 🕹️ How to Run the Project

1.  **Prerequisites:** Ensure you have the Java Development Kit (JDK) installed (version 8 or newer recommended).
2.  **Compilation:** Compile the Java files:
    ```bash
    javac Main.java GOLPanel.java GOLMatrix.java
    ```
3.  **Execution:** Run the main class:
    ```bash
    java Main
    ```

## 📋 Controls

| Button | Action | Description |
| :--- | :--- | :--- |
| **Grid Cell** | Toggle State | Toggles the cell state between **Alive (Blue)** and **Dead (White)**. |
| **Go** | Start/Stop | Starts the automatic simulation loop. Changes to 'Stop' while running. |
| **Next** | Step Forward | Advances the simulation by exactly one generation. |
| **Clear** | Reset | Clears all living cells from the grid and resets the generation count to 0. |
| **Faster** | Speed Up | Decreases the interval between generations (min 100ms). |
| **Slower** | Slow Down | Increases the interval between generations (max 1000ms). |

## ⚙️ Game of Life Rules (Implemented in `GOLMatrix`)

The `nextGeneration` method applies the standard four rules of Conway's Game of Life, where the state of a cell in the next generation depends on the number of its eight neighbors: 
1.  **Underpopulation:** Any live cell with **fewer than two** live neighbors dies (as if by loneliness).
2.  **Survival:** Any live cell with **two or three** live neighbors lives on to the next generation.
3.  **Overpopulation:** Any live cell with **more than three** live neighbors dies (as if by overpopulation).
4.  **Reproduction:** Any dead cell with **exactly three** live neighbors becomes a live cell (as if by reproduction).
