/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated.asset_tracker_schema.tables;


import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function3;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row3;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.generated.asset_tracker_schema.AssetTrackerSchema;
import org.jooq.generated.asset_tracker_schema.Keys;
import org.jooq.generated.asset_tracker_schema.tables.records.WalletRecord;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Wallet extends TableImpl<WalletRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>asset_tracker_schema.wallet</code>
     */
    public static final Wallet WALLET = new Wallet();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<WalletRecord> getRecordType() {
        return WalletRecord.class;
    }

    /**
     * The column <code>asset_tracker_schema.wallet.id</code>.
     */
    public final TableField<WalletRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>asset_tracker_schema.wallet.asset_id</code>.
     */
    public final TableField<WalletRecord, Long> ASSET_ID = createField(DSL.name("asset_id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>asset_tracker_schema.wallet.asset_amount</code>.
     */
    public final TableField<WalletRecord, Integer> ASSET_AMOUNT = createField(DSL.name("asset_amount"), SQLDataType.INTEGER.nullable(false), this, "");

    private Wallet(Name alias, Table<WalletRecord> aliased) {
        this(alias, aliased, null);
    }

    private Wallet(Name alias, Table<WalletRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>asset_tracker_schema.wallet</code> table
     * reference
     */
    public Wallet(String alias) {
        this(DSL.name(alias), WALLET);
    }

    /**
     * Create an aliased <code>asset_tracker_schema.wallet</code> table
     * reference
     */
    public Wallet(Name alias) {
        this(alias, WALLET);
    }

    /**
     * Create a <code>asset_tracker_schema.wallet</code> table reference
     */
    public Wallet() {
        this(DSL.name("wallet"), null);
    }

    public <O extends Record> Wallet(Table<O> child, ForeignKey<O, WalletRecord> key) {
        super(child, key, WALLET);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : AssetTrackerSchema.ASSET_TRACKER_SCHEMA;
    }

    @Override
    public Identity<WalletRecord, Long> getIdentity() {
        return (Identity<WalletRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<WalletRecord> getPrimaryKey() {
        return Keys.CONSTRAINT_D;
    }

    @Override
    public List<ForeignKey<WalletRecord, ?>> getReferences() {
        return Arrays.asList(Keys.FK_WALLET_ASSET);
    }

    private transient Asset _asset;

    /**
     * Get the implicit join path to the <code>asset_tracker_schema.asset</code>
     * table.
     */
    public Asset asset() {
        if (_asset == null)
            _asset = new Asset(this, Keys.FK_WALLET_ASSET);

        return _asset;
    }

    @Override
    public Wallet as(String alias) {
        return new Wallet(DSL.name(alias), this);
    }

    @Override
    public Wallet as(Name alias) {
        return new Wallet(alias, this);
    }

    @Override
    public Wallet as(Table<?> alias) {
        return new Wallet(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Wallet rename(String name) {
        return new Wallet(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Wallet rename(Name name) {
        return new Wallet(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Wallet rename(Table<?> name) {
        return new Wallet(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<Long, Long, Integer> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function3<? super Long, ? super Long, ? super Integer, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function3<? super Long, ? super Long, ? super Integer, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}