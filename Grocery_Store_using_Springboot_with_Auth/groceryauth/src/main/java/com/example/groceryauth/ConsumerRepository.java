public interface ConsumerRepository extends JpaRepository<Consumer, Integer> {
    Optional<Consumer> findByEmail(String email);
}
