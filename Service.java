public interface Service
        <T> {                                //simple interface with important method
    public T find(Object primaryKey); //finding id of customer in dbms
    public void save(int object);         //saving changes in dbms
}

