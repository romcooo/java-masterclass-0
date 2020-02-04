package com.romco.oreillypersistence.entity;


import javax.persistence.*;

@Entity
@Table(name = "officer")
public class Officer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Enumerated(EnumType.STRING)
    private Rank rank;
    
    @Column(name = "first_name", nullable = false)
    private String first;
    @Column(name = "last_name", nullable = false)
    private String last;
    
    public Officer() {
    }
    
    public Officer(Rank rank, String first, String last) {
        this.rank = rank;
        this.first = first;
        this.last = last;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        Officer officer = (Officer) o;
        
        if (id != null ? !id.equals(officer.id) : officer.id != null) return false;
        if (rank != officer.rank) return false;
        if (first != null ? !first.equals(officer.first) : officer.first != null) return false;
        return last != null ? last.equals(officer.last) : officer.last == null;
    }
    
    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (rank != null ? rank.hashCode() : 0);
        result = 31 * result + (first != null ? first.hashCode() : 0);
        result = 31 * result + (last != null ? last.hashCode() : 0);
        return result;
    }
    
    @Override
    public String toString() {
        return "Officer{" +
                "id=" + id +
                ", rank=" + rank +
                ", first='" + first + '\'' +
                ", last='" + last + '\'' +
                '}';
    }
    
    public Officer(Integer id, Rank rank, String first, String last) {
        this.id = id;
        this.rank = rank;
        this.first = first;
        this.last = last;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Rank getRank() {
        return rank;
    }
    
    public void setRank(Rank rank) {
        this.rank = rank;
    }
    
    public String getFirst() {
        return first;
    }
    
    public void setFirst(String first) {
        this.first = first;
    }
    
    public String getLast() {
        return last;
    }
    
    public void setLast(String last) {
        this.last = last;
    }
}
