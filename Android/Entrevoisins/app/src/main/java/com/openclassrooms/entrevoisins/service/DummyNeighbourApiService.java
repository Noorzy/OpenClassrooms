package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements  NeighbourApiService {

    private List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();


    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);
    }

    @Override
    public void changeFavoriteCheck (Neighbour neighbour){
        Neighbour check;
        check = neighbours.get(neighbours.indexOf(neighbour));
        if (check.isFavoriteCheck() == true) {
            check.setFavoriteCheck(false);
        }else{
            check.setFavoriteCheck(true);
        }

    }
}
