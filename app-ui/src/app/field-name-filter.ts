import {Pipe} from "@angular/core";
import {PipeTransform} from "@angular/core";

@Pipe({name: 'nameFilter'})
export class FieldNameFilter implements PipeTransform {

    transform(key:any) {
        const names = {
            'chequing': 'Chequing',
            'savingsForTaxes': 'Savings for Taxes',
            'rainyDayFund': 'Rainy Day Fund',
            'savingsForFun': 'Savings for Fun',
            'savingsForTravel': 'Savings for Travel',
            'savingsForPD': 'Savings for Personal Development',
            'investment1': 'Investment 1',
            'investment2': 'Investment 2',
            'investment3': 'Investment 3',
            'investment4': 'Investment 4',
            'investment5': 'Investment 5',
            'primaryHome': 'Primary Home',
            'secondHome': 'Second Home',
            'otherLTA': 'Other',
            'creditCard1': 'Credit Card 1',
            'creditCard2': 'Credit Card 2',
            'otherSTL': '(others…)',
            'mortgage1': 'Mortgage 1',
            'mortgage2': 'Mortgage 2',
            'lineOfCredit': 'Line of Credit',
            'investmentLoan': 'Investment Loan',
            'studentLoan': 'Student Loan',
            'carLoan': 'Car Loan'
        };
       
        if (key) {
            return names[key];
        }
        return '';
    }

}