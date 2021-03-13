package kz.aitu.oop.assignment;

public interface Servise {
    <T> {//simple interface with important method
        public T findById(Object primaryKey); //finding id of customer in dbms
        public void save(T object);//saving changes in dbms
    }
}
