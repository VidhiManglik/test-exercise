CREATE TABLE IF NOT EXISTS score (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    player_id BIGINT,
    player_name VARCHAR(255),
    player_score INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT unique_player_id UNIQUE (player_id)
);

-- Insert data into the table
INSERT INTO score (player_id, player_name, player_score) VALUES
(1, 'Alice', 150),
(2, 'Bob', 200),
(3, 'Charlie', 180);

-- Create index in descending order on player_score column
CREATE INDEX IF NOT EXISTS idx_player_score ON score (player_score DESC);
