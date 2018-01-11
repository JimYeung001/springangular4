import { Component, OnInit, OnDestroy } from '@angular/core';
import { FormControl, FormGroup, Validators, FormBuilder } from '@angular/forms';
import { NetworthService } from '../networth.service';
import { NetWorth } from '../networth-model/net-worth';
import { ActivatedRoute, Router } from '@angular/router';
import { CurrencyPipe } from '@angular/common';
import { FormArray } from '@angular/forms/src/model';
import { CapitalizePipe } from '../../capitalize-piple';
import { FieldNameFilter } from '../../field-name-filter';

const VALIDATOERS_ARRAY = [Validators.required, Validators.minLength(0), Validators.maxLength(13)];
const UNDEFINED: string = 'undefined';
const FORM_CONTROL_NAME: string = 'ng-reflect-name';
const OBJECT: string = 'object';
const EMPTY_STRING: string = '';
const ID_STRING: string = 'id';
const CURRENCY_USD: string = 'USD';
const CURRENCY_PATTERN: string = '1.2-2';
const CASH_AND_INVESTMENTS: string = 'cashAndInvestments';
const LONG_TERM_ASSETS: string = 'longTermAssets';
const SHORT_TERM_LIABILITIES: string = 'shortTermLiab';
const LONG_TERM_DEBT: string = 'longTermDebt';
const TOTAL_AMOUNT: string = 'totalAmount';


@Component({
  selector: 'app-networth-edit',
  templateUrl: './networth-edit.component.html',
  styleUrls: ['./networth-edit.component.css'],
  providers: [NetworthService, CurrencyPipe, CapitalizePipe, FieldNameFilter]
})
export class NetworthEditComponent implements OnInit, OnDestroy {

  sub: any;
  id: number;
  yourNetworth: number;
  totalAssets: number;
  totalLiabilities: number;
  networth: NetWorth;
  networthFormGroup: FormGroup;
  cashAndInvestmentsArray: any[];
  longTermAssetsArray: string[];
  longTermDebtArray: string[];
  shortTermLiabArray: string[];

  /**
   *  Default Contructor
   * @param networthService 
   * @param fb 
   * @param currencyPipe 
   * @param route 
   */
  constructor(private networthService: NetworthService,
    private fb: FormBuilder,
    private currencyPipe: CurrencyPipe,
    private route: ActivatedRoute) {
    this.networthFormGroup = this.fb.group({});
    this.cashAndInvestmentsArray = new Array();
    this.longTermAssetsArray = new Array();
    this.longTermDebtArray = new Array();
    this.shortTermLiabArray = new Array();

  }

  /**
   * Populate FormGroup with the model properties, and populate control names
   */
  createFormGroup() {
    Object.getOwnPropertyNames(this.networth).forEach(k1 => {
      if (typeof this.networth[k1] === OBJECT) {
        switch (k1) {
          case CASH_AND_INVESTMENTS:
            Object.getOwnPropertyNames(this.networth[k1]).forEach(k2 => {
              if (k2 == ID_STRING || k2 == TOTAL_AMOUNT) {
              } else {
                this.cashAndInvestmentsArray.push(k2);
                this.networthFormGroup.addControl(k2, new FormControl(
                  this.formatNumber(this.networth[k1][k2]), VALIDATOERS_ARRAY));
              }
            });
            break;
          case LONG_TERM_ASSETS:
            Object.getOwnPropertyNames(this.networth[k1]).forEach(k2 => {
              if (k2 == ID_STRING || k2 == TOTAL_AMOUNT) {
              } else {
                this.longTermAssetsArray.push(k2);
                this.networthFormGroup.addControl(k2, new FormControl(
                  this.formatNumber(this.networth[k1][k2]), VALIDATOERS_ARRAY));
              }
            });
            break;
          case SHORT_TERM_LIABILITIES:
            Object.getOwnPropertyNames(this.networth[k1]).forEach(k2 => {
              if (k2 == ID_STRING || k2 == TOTAL_AMOUNT) {
              } else {
                this.shortTermLiabArray.push(k2);
                this.networthFormGroup.addControl(k2, new FormControl(
                  this.formatNumber(this.networth[k1][k2]), VALIDATOERS_ARRAY));
              }
            });
            break;
          case LONG_TERM_DEBT:
            Object.getOwnPropertyNames(this.networth[k1]).forEach(k2 => {
              if (k2 == ID_STRING || k2 == TOTAL_AMOUNT) {
              } else {
                this.longTermDebtArray.push(k2);
                this.networthFormGroup.addControl(k2, new FormControl(
                  this.formatNumber(this.networth[k1][k2]), VALIDATOERS_ARRAY));
              }
            });
            break;
        }
      } else {
        this.networthFormGroup.addControl(k1, new FormControl(this.formatNumber(this.networth[k1])));
      }
    });
  }

  /**
   * inital hook
   */
  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      this.id = params[ID_STRING];
    });

    this.findOneById(this.id);
  }


  /**
   * Find model by ID
   * @param id model ID
   */
  findOneById(id: number) {
    this.networthService.findOneById(id).subscribe(
      networth => {
        this.networth = networth;
        this.createFormGroup();
        this.yourNetworth = this.networth.netWorth;
        this.totalAssets = this.networth.totalAssets;
        this.totalLiabilities = this.networth.totalLiabilities;
      },
      err => { console.log(err) }
    );
  }


  /**
   * Input Change handler
   * @param event 
   */
  onInputChange(event: any) {
    if (typeof event != UNDEFINED && event != EMPTY_STRING && typeof (<HTMLInputElement>event.target) != UNDEFINED) {
      let name: string = (<HTMLInputElement>event.target).attributes.getNamedItem(FORM_CONTROL_NAME).value;
      let c = this.getFromControlByName(name);
      if (c != null && c.valid) {
        let value = parseFloat(c.value.replace(/[^0-9\.-]+/g, EMPTY_STRING));
        let val_string = this.formatNumber(value);
        c.patchValue(val_string);
        // let invalids = this.findInvalidControls();
        if (val_string.length < 14 && this.networthFormGroup.valid) {
          this.refreshEntity(name, value);
          //call service to persist to database
          this.persistToDatabase();
        }
      }
    }
  }

  /**
   * Test only for finding out invalid controls
   */
  findInvalidControls() {
    let invalids = [];
    let controls = this.networthFormGroup.controls;
    for (let n in controls) {
      if (controls[n].invalid) {
        invalids.push(n)
      }
    }
    return invalids;
  }

  /**
   * Get Form control by the name
   * @param name  Control name
   */
  getFromControlByName(name: string) {
    if (name != EMPTY_STRING) {
      return this.networthFormGroup.get(name);
    }
  }

  /**
   * Persist date to DB
   */
  persistToDatabase() {
    this.networthService.updateNetworth(this.networth).subscribe(nw => {
      this.networth = nw;
      //Fresh networth
      this.yourNetworth = this.networth.netWorth;
      this.totalAssets = this.networth.totalAssets;
      this.totalLiabilities = this.networth.totalLiabilities;
    },
      err => { console.log(err) });
  }

  /**
   * Sync model data once it's dirty
   * @param name 
   * @param value 
   */
  refreshEntity(name: string, value: number) {
    Object.getOwnPropertyNames(this.networth).forEach(k1 => {
      if (typeof this.networth[k1] === OBJECT) {
        Object.getOwnPropertyNames(this.networth[k1]).forEach(k2 => {
          if (name == k2) {
            this.networth[k1][k2] = +value;
          }
        });
      } else {
        if (name == k1) {
          this.networth[k1] = +value;
        }
      }
    });
  }


  /**
   * Format the input to currency decimal
   * @param value 
   */
  formatNumber(value: any) {
    return this.currencyPipe.transform(value, CURRENCY_USD, true, CURRENCY_PATTERN);
  }

  /**
   * After component destroied. 
   */
  ngOnDestroy(): void {
    this.sub.unsubscribe();
  }

}
