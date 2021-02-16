package co.com.balance.api;

import co.com.balance.model.account.Account;
import co.com.balance.model.balance.Balance;
import co.com.balance.model.movements.Movements;
import co.com.balance.usecase.balance.BalanceUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class Handler {

    private BalanceUseCase balanceUseCase;

    public Mono<ServerResponse> getBalance(ServerRequest serverRequest) {

        Mono<Balance>  result =  balanceUseCase.getBalanceAccount();
        return ServerResponse.ok().body(result, Balance.class);
    }

    public Mono<ServerResponse> getMovements(ServerRequest serverRequest) {

        Mono<Movements>  result =  balanceUseCase.geMovements();
        return ServerResponse.ok().body(result, Movements.class);

    }

    public Mono<ServerResponse> getBalanceAndMovents(ServerRequest serverRequest) {

        Mono<Account>  result =  balanceUseCase.getBalanceAndMovements();
        return ServerResponse.ok().body(result, Account.class);
    }
}
