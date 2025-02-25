package real.world.domain.follow.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;
import lombok.Getter;
import real.world.domain.user.entity.User;

@Getter
@Entity(name = "follows")
@IdClass(Follow.FollowId.class)
public class Follow {

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "follower_id")
    private User follower;

    protected Follow() {
    }

    public Follow(User user, User follower) {
        this.user = user;
        this.follower = follower;
    }

    static class FollowId implements Serializable {

        private final Long user;
        private final Long follower;

        public FollowId(Long user, Long follower) {
            this.user = user;
            this.follower = follower;
        }
    }

}
