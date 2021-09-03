package com.example.federation.datafetchers;

import com.netflix.dgs.codgen.generated.types.Show;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@DgsComponent
public class ShowsDataFetcher {

    @DgsQuery(field = "shows")
    public CompletableFuture<List<Show>> shows(@InputArgument("titleFilter") String titleFilter, DgsDataFetchingEnvironment dfe) {
        List<Show> shows = List.of(
                Show.newBuilder().id("1").title("show-1").releaseYear(2021).build(),
                Show.newBuilder().id("2").title("show-2").releaseYear(2021).build(),
                Show.newBuilder().id("3").title("show-3").releaseYear(2021).build()
        );

/*        if (titleFilter == null){
            return null;
        }

        List<Show> result = shows.stream()
                .filter(show -> show.getTitle().equals(titleFilter))
                .collect(Collectors.toList());*/

        return CompletableFuture.completedFuture(shows);
    }

}
