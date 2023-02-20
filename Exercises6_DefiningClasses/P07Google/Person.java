package Exercises6_DefiningClasses.P07Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private Company company;
    private Car car;
    private List<Children> children;
    private List<Parents> parents;
    private List<Pokemon> pokemon;


    public Person(){
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.pokemon = new ArrayList<>();
    }
    public Person(Company company, Car car, List<Children> children, List<Parents> parents, List<Pokemon> pokemon) {
        this.company = company;
        this.car = car;
        this.children = children;
        this.parents = parents;
        this.pokemon = pokemon;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Children> getChildren() {
        return this.children;
    }

    public List<Parents> getParents(){
        return this.parents;
    }

    public List<Pokemon> getPokemons() {
        return this.pokemon;
    }


    @Override
    public String toString(){

        StringBuilder sb = new StringBuilder();

        sb.append("Company:").append(System.lineSeparator());
        if (company != null){
            sb.append(company).append(System.lineSeparator());
        }

        sb.append("Car:").append(System.lineSeparator());
        if (car != null){
            sb.append(car).append(System.lineSeparator());
        }

        sb.append("Pokemon:").append(System.lineSeparator());
        for (Pokemon pokemon : pokemon) {

            sb.append(pokemon).append(System.lineSeparator());
        }

        sb.append("Parents:").append(System.lineSeparator());
        for (Parents parent : parents) {

            sb.append(parent).append(System.lineSeparator());
        }
        sb.append("Children:").append(System.lineSeparator());
        for (Children child : children) {

            sb.append(child).append(System.lineSeparator());
        }

        return sb.toString();
    }
}
