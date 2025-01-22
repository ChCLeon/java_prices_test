CREATE TABLE IF NOT EXISTS PRODUCT_PRICES (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    brand_id BIGINT,
    start_date TIMESTAMP,
    end_date TIMESTAMP,
    price_list BIGINT,
    product_id INT,
    priority INT,
    price FLOAT,
    currency VARCHAR(3)
);