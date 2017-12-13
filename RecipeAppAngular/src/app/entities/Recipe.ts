import { User } from "./User";
import { Category } from "./Category";
import { Ingredient } from "./Ingredient";
import { Difficulty } from "./Difficulty";

export class Recipe {
    recipeId: Number;
    recipeName: String;
    cookingTime: Number;
    dateCreated: Date;
    directions: string;
    upvotes: number;
    flag: boolean;
    difficulty: Difficulty;
    creator: User;
    ingredients: Array<Ingredient>;
    categories: Array<Category>;
}