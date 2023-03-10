package com.assettracker.wallet;

import io.vertx.core.Handler;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.pgclient.PgPool;
import org.jooq.SQLDialect;
import org.jooq.generated.asset_tracker_schema.tables.Wallet;
import org.jooq.impl.DSL;

public final class WalletHandler implements Handler<RoutingContext> {
    private final Router _router;
    private final PgPool _pool;

    private static final String rootPath = "/wallet/";

    public WalletHandler(Router router, PgPool pool) {
        _router = router;
        _pool = pool;
    }

    private void getWallet(RoutingContext ctx) {

        var sql = DSL.using(SQLDialect.POSTGRES).selectFrom(Wallet.WALLET)
                .where(Wallet.WALLET.ID.eq(ctx.get("ID"))).getSQL();

        var rowSetFuture = _pool.query(sql).execute();

        rowSetFuture
            .onSuccess(ctx::json)
            .onFailure(ctx::json);
    }

    @Override
    public void handle(RoutingContext context) {
        _router.get(rootPath.concat("test")).handler(this::getWallet);
        _router.handleContext(context);
    }
}