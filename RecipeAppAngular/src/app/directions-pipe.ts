import {Pipe, PipeTransform} from '@angular/core'

@Pipe({
    name: 'directions'
})

export class DirectionsPipe implements PipeTransform {
    transform(directions: string) {

        let numberedDirections: string;
        numberedDirections = '';
        let counter = 1;
 
        
        while(directions.includes('.')) {

            let subString: string;

            subString = directions.substring(0, directions.indexOf(".") + 1);
  
            directions = directions.slice(directions.indexOf(".") + 1, directions.length)

            
            numberedDirections = numberedDirections.concat(counter.toString(), '. ', subString.trim(), `
            `);
     
            counter++;
        }

        return numberedDirections;
        
    }
    
}