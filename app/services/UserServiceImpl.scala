package services

import javax.inject._
import models.User
import scalikejdbc.DBSession

import scala.util.Try

@Singleton
class UserServiceImpl extends UserService {

  override def create(user: User)(implicit dBSession: DBSession): Try[Long] = Try {
    User.create(user)
  }

  override def findById(userId: Long)(implicit dBSession: DBSession): Try[Option[User]] = Try {
    User.allAssociations.findById(userId)
  }

  override def findByEmail(email: String)(implicit dBSession: DBSession): Try[Option[User]] = Try {
    User.allAssociations.where('email -> email).apply().headOption
  }
}
