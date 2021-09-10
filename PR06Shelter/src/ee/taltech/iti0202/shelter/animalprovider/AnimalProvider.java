package ee.taltech.iti0202.shelter.animalprovider;

import ee.taltech.iti0202.shelter.animal.Animal;

import java.util.List;

/**
 * Interface for animal provider.
 * The goal of the provider is to ... provide animals.
 */
public interface AnimalProvider {
    /**
     * Provides a list of animals of the given type.
     * The list can be empty if there is nothing to provide at the moment.
     * The provider remembers the last call and should have new results when calling multiple times.
     * Due to some logic, consecutive calls can result in overlapping results.
     * So, this method will not return all the animals available.
     * You can rather think it returns some portion of the animals.
     * To get more, you have to call it again.
     *
     * @param type Which animals are asked.
     * @return A limited list of animals of asked type
     */
    List<Animal> provide(Animal.Type type);
}
