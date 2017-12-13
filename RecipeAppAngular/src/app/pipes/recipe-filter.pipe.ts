import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'recipeFilter'
})
export class RecipeFilterPipe implements PipeTransform {

  transform(recipes: any, user: any): any {
      return recipes.filter(recipe => recipe.creator.id === user);
    }
  }

