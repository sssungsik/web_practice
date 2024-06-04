// script.js
document.addEventListener("DOMContentLoaded", () => {
    const board = document.getElementById("game-board");
    const rows = 8;
    const cols = 8;
    let gameBoard = Array(rows).fill(null).map(() => Array(cols).fill(null));

    function initBoard() {
        for (let row = 0; row < rows; row++) {
            for (let col = 0; col < cols; col++) {
                const cell = document.createElement("div");
                cell.className = "cell";
                cell.dataset.row = row;
                cell.dataset.col = col;
                cell.addEventListener("click", handleCellClick);
                board.appendChild(cell);
            }
        }
        // Initialize the starting disks
        placeDisk(3, 3, "white");
        placeDisk(3, 4, "black");
        placeDisk(4, 3, "black");
        placeDisk(4, 4, "white");
    }

    function placeDisk(row, col, color) {
        const cell = document.querySelector(`.cell[data-row="${row}"][data-col="${col}"]`);
        const disk = document.createElement("div");
        disk.className = `disk ${color}`;
        cell.appendChild(disk);
        gameBoard[row][col] = color;
    }

    function handleCellClick(event) {
        const row = event.target.dataset.row;
        const col = event.target.dataset.col;
        // Add game logic to place a disk and flip opponent's disks
    }

    initBoard();
});
