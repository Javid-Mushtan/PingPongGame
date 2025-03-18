# PingPongGame
A simple 2D Ping Pong game implemented in Java using Swing and AWT libraries. This project is a classic two-player game where each player controls a paddle to hit the ball and score points.

Features
1.) Two-player gameplay: Player 1 controls the left paddle using W (up) and S (down) keys. Player 2 controls the right paddle using the UP and DOWN arrow keys.

2.) Score tracking: The game keeps track of each player's score and displays it on the screen.

3.) Pause and Continue: The game can be paused when a player wins, and you can choose to continue or terminate the game.

4.) Dynamic ball movement: The ball changes direction when it hits the paddles or the top/bottom walls.

5.) Game Over: When the ball goes out of bounds, the game declares the winner and resets the ball for the next round.

# PingPongGame

A simple Ping Pong game built in Java where two players can compete. Player 1 uses the W and S keys to move the paddle, while Player 2 uses the UP and DOWN arrow keys. The game window will open once you run the main method in the `PingPongGame.java` class.

---

## Prerequisites

- **Java Development Kit (JDK)**: Ensure you have the Java Development Kit installed on your system.
- **Clone the Repository**: Clone this repository to your local machine using Git.

---

## Running the Game

1. **Open the Project**: Open the project in **Eclipse** or any Java IDE.
2. **Navigate to the Game**: Find the `PingPongGame.java` file.
3. **Run the Game**: Run the `main` method in the `PingPongGame` class. The game window will open, and you can start playing.

---

## Controls

### Player 1:
- **W** key: Move paddle up.
- **S** key: Move paddle down.

### Player 2:
- **UP Arrow**: Move paddle up.
- **DOWN Arrow**: Move paddle down.

---

## Code Structure

- **PingPongGame.java**: The main class that implements the game logic, graphics, and event handling.
  - **`paintComponent(Graphics g)`**: Handles rendering of the game objects (paddles, ball, and scores).
  - **`keyPressed(KeyEvent e)`** and **`keyReleased(KeyEvent e)`**: Handle keyboard input for paddle movement.
  - **`run()`**: The game loop that updates the ball and paddle positions.
  - **`resetBall()`**: Resets the ball to the center of the screen.
  - **`paused()`**: Handles the pause and continue functionality.

---

## Dependencies

This project uses Java's built-in libraries:

- **`java.awt.*`**: For graphics and event handling.
- **`javax.swing.*`**: For creating the game window and UI components.

---

## Future Improvements

- **Start Menu**: Add a start menu with options for single-player vs. AI or two-player mode.
- **Difficulty Levels**: Implement difficulty levels, such as increasing ball speed over time.
- **Sound Effects**: Add sound effects for ball hits and scoring.
- **Improved UI**: Enhance the UI with animations and better graphics.

---

## Contributing

Contributions are welcome! If you'd like to contribute to this project, please follow these steps:

1. **Fork** the repository.
2. Create a new branch for your feature or bugfix.
3. **Commit** your changes and **push** them to your branch.
4. Submit a **pull request** with a detailed description of your changes.

---

## License

This project is licensed under the **MIT License**. See the [LICENSE](LICENSE) file for details.

---

## Author

**Javid-Mushtan**  
GitHub: [https://github.com/Javid-Mushtan](https://github.com/Javid-Mushtan)

---

## How to Create the README.md File in Eclipse

1. Right-click on your project in the **Package Explorer**.
2. Select **New > File**.
3. Name the file `README.md`.
4. Paste the above content into the file.
5. **Save** the file.

---

## Push to GitHub

1. **Commit** the `README.md` file to your local Git repository.
2. **Push** the changes to your GitHub repository.
