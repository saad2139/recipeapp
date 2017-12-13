import { Role } from "./Role";

export class User {
    id: Number;
    username: String;
    password: String;
    email: String;
    first_name: String;
    last_name: String;
    role: Role;
    following_list: Array<User>;
    
}