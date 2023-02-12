/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated.asset_tracker_schema.tables;


import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function4;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row4;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.generated.asset_tracker_schema.AssetTrackerSchema;
import org.jooq.generated.asset_tracker_schema.Keys;
import org.jooq.generated.asset_tracker_schema.tables.records.AssetPriceRecord;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AssetPrice extends TableImpl<AssetPriceRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>asset_tracker_schema.asset_price</code>
     */
    public static final AssetPrice ASSET_PRICE = new AssetPrice();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<AssetPriceRecord> getRecordType() {
        return AssetPriceRecord.class;
    }

    /**
     * The column <code>asset_tracker_schema.asset_price.id</code>.
     */
    public final TableField<AssetPriceRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>asset_tracker_schema.asset_price.asset_id</code>.
     */
    public final TableField<AssetPriceRecord, Long> ASSET_ID = createField(DSL.name("asset_id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>asset_tracker_schema.asset_price.currency_id</code>.
     */
    public final TableField<AssetPriceRecord, Long> CURRENCY_ID = createField(DSL.name("currency_id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>asset_tracker_schema.asset_price.price</code>.
     */
    public final TableField<AssetPriceRecord, BigInteger> PRICE = createField(DSL.name("price"), SQLDataType.DECIMAL_INTEGER(100000).nullable(false), this, "");

    private AssetPrice(Name alias, Table<AssetPriceRecord> aliased) {
        this(alias, aliased, null);
    }

    private AssetPrice(Name alias, Table<AssetPriceRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>asset_tracker_schema.asset_price</code> table
     * reference
     */
    public AssetPrice(String alias) {
        this(DSL.name(alias), ASSET_PRICE);
    }

    /**
     * Create an aliased <code>asset_tracker_schema.asset_price</code> table
     * reference
     */
    public AssetPrice(Name alias) {
        this(alias, ASSET_PRICE);
    }

    /**
     * Create a <code>asset_tracker_schema.asset_price</code> table reference
     */
    public AssetPrice() {
        this(DSL.name("asset_price"), null);
    }

    public <O extends Record> AssetPrice(Table<O> child, ForeignKey<O, AssetPriceRecord> key) {
        super(child, key, ASSET_PRICE);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : AssetTrackerSchema.ASSET_TRACKER_SCHEMA;
    }

    @Override
    public Identity<AssetPriceRecord, Long> getIdentity() {
        return (Identity<AssetPriceRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<AssetPriceRecord> getPrimaryKey() {
        return Keys.CONSTRAINT_5F;
    }

    @Override
    public List<ForeignKey<AssetPriceRecord, ?>> getReferences() {
        return Arrays.asList(Keys.FK_PRICE_ASSET, Keys.FK_PRICE_CURRENCY);
    }

    private transient Asset _asset;
    private transient Currency _currency;

    /**
     * Get the implicit join path to the <code>asset_tracker_schema.asset</code>
     * table.
     */
    public Asset asset() {
        if (_asset == null)
            _asset = new Asset(this, Keys.FK_PRICE_ASSET);

        return _asset;
    }

    /**
     * Get the implicit join path to the
     * <code>asset_tracker_schema.currency</code> table.
     */
    public Currency currency() {
        if (_currency == null)
            _currency = new Currency(this, Keys.FK_PRICE_CURRENCY);

        return _currency;
    }

    @Override
    public AssetPrice as(String alias) {
        return new AssetPrice(DSL.name(alias), this);
    }

    @Override
    public AssetPrice as(Name alias) {
        return new AssetPrice(alias, this);
    }

    @Override
    public AssetPrice as(Table<?> alias) {
        return new AssetPrice(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public AssetPrice rename(String name) {
        return new AssetPrice(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public AssetPrice rename(Name name) {
        return new AssetPrice(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public AssetPrice rename(Table<?> name) {
        return new AssetPrice(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row4<Long, Long, Long, BigInteger> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function4<? super Long, ? super Long, ? super Long, ? super BigInteger, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function4<? super Long, ? super Long, ? super Long, ? super BigInteger, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
