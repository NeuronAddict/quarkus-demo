package tech.woodandsafety;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import io.smallrye.mutiny.helpers.test.UniAssertSubscriber;
import org.hamcrest.Matchers;
import org.hibernate.reactive.mutiny.Mutiny;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Need a database
 */
@QuarkusTest
class FruitTest {


    @Test
    @TestTransaction
    void testSearch() {

        Fruit.deleteAll().await().indefinitely();

        Fruit fruit1 = new Fruit();
        fruit1.name = "apple";
        fruit1.persistAndFlush().await().indefinitely();

        Fruit fruit2 = new Fruit();
        fruit2.name = "banana";
        fruit2.persistAndFlush().await().indefinitely();

        UniAssertSubscriber<List<Fruit>> subscriber = Fruit.searchByName("na").subscribe().withSubscriber(UniAssertSubscriber.create());

        List<Fruit> item = subscriber.awaitItem().getItem();
        assertThat(item, Matchers.hasSize(1));
        assertThat(item.get(0).name, is("banana"));
    }

    @Test
    @TestTransaction
    void testGetByName() {

        Fruit.deleteAll().await().indefinitely();

        Fruit fruit1 = new Fruit();
        fruit1.name = "apple";
        fruit1.persist().await().indefinitely();

        UniAssertSubscriber<Fruit> subscriber = Fruit.getByName("apple").subscribe().withSubscriber(UniAssertSubscriber.create());

        subscriber.awaitItem().assertCompleted().assertItem(fruit1);

    }

}