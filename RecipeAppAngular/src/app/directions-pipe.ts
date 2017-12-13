import {Pipe, PipeTransform} from '@angular/core'

@Pipe({
    name: 'directions'
})

export class DirectionsPipe implements PipeTransform {
    transform(directions: string) {
        console.log(directions);
        let numberedDirections: string;
        numberedDirections = '';
        let counter = 1;
        console.log(directions.includes('.'));
        
        while(directions.includes('.')) {
            console.log('in loop');
            let subString: string;

            subString = directions.substring(0, directions.indexOf(".") + 1);
            console.log(subString);
            directions = directions.slice(directions.indexOf(".") + 1, directions.length)
            console.log(directions);

            
            numberedDirections = numberedDirections.concat(counter.toString(), '. ', subString.trim(), `
            `);
     
            counter++;
        }

        return numberedDirections;
        
    }
    
}