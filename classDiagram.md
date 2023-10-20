```mermaid

classDiagram
  class User {
    id: int
    user: string
    pass: string
    enrolled: List<Enrolled>
  }

  class Enrolled {
    id: int
    name: string
    phone: string
    cpf: string
    email: string
    plan: Plan
    status: Status
  }

  class Plan {
    id: int
    description: string
    price: double
  }

  class Status {
    id: int
    description: string
  }

  User "1" *-- "N" Enrolled
  Enrolled "N" *-- "1" Plan
  Enrolled "N" *-- "1" Status

```