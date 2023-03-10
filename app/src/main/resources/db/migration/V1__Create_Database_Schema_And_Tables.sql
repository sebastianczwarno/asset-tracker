CREATE SCHEMA IF NOT EXISTS asset_tracker_schema;

CREATE TABLE asset_tracker_schema.asset
(
    id   bigserial   NOT NULL PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE asset_tracker_schema.currency
(
    id          bigserial    NOT NULL PRIMARY KEY,
    code        VARCHAR(3)   NOT NULL,
    description VARCHAR(100) NOT NULL
);

CREATE TABLE asset_tracker_schema.asset_price
(
    id          bigserial NOT NULL PRIMARY KEY,
    asset_id    bigserial NOT NULL,
    currency_id bigserial NOT NULL,
    price       decimal   NOT NULL,
    CONSTRAINT fk_price_asset FOREIGN KEY (asset_id) REFERENCES asset_tracker_schema.asset (id),
    CONSTRAINT fk_price_currency FOREIGN KEY (currency_id) REFERENCES asset_tracker_schema.currency (id)
);

CREATE TABLE asset_tracker_schema.wallet
(
    id bigserial NOT NULL PRIMARY KEY,
    asset_id bigserial NOT NULL,
    asset_amount INTEGER NOT NULL,
    CONSTRAINT fk_wallet_asset FOREIGN KEY (asset_id) REFERENCES asset_tracker_schema.asset (id)
);

CREATE TABLE asset_tracker_schema.asset_price_under_wallet
(
    id bigserial NOT NULL PRIMARY KEY,
    wallet_id bigserial NOT NULL,
    asset_name VARCHAR(50) NOT NULL,
    currency_code VARCHAR(3) NOT NULL,
    price decimal NOT NULL,
    CONSTRAINT fk_asset_price_under_wallet_wallet FOREIGN KEY (wallet_id) REFERENCES asset_tracker_schema.wallet (id)
);
