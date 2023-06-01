package bednarhalaj.model.users.db;

import bednarhalaj.model.DBEntity;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor(force = true)
@EqualsAndHashCode(callSuper = true)
public class DBUser extends DBEntity implements Serializable {

    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private Role role;

    private DBUser(DBUser.Builder builder) {
        this.name = builder.name;
        this.password = builder.password;
        this.role = builder.role;
    }

    @Override
    public String toString() {
        return name;
    }

    public static class Builder {
        private final String name;
        private String password;
        private Role role;

        public Builder(String name) {
            this.name = name;
        }

        public DBUser.Builder password(String password) {
            this.password = password;
            return this;
        }

        public DBUser.Builder role(Role role) {
            this.role = role;
            return this;
        }

        public DBUser build() {
            return new DBUser(this);
        }
    }

}
