import { Component, Input } from '@angular/core';
import { AbstractControlDirective, AbstractControl } from '@angular/forms';


@Component({
    selector: 'show-errors',
    template: `<p *ngIf="shouldShowErrors()">
                    <span class="text-danger" *ngFor="let error of listErrors()">{{error}}</span>
                </p>`
})
export class ErrorComponent {

    private static readonly errorMessages = {
        'required': () => 'This field is required.',
        'minlength': (params) => 'The min number of characters is ' + params.requiredLength,
        'maxlength': (params) => 'The max numeric digits including "," and "$" are ' + params.requiredLength
    }

    @Input()
    private control: AbstractControlDirective | AbstractControl;

    shouldShowErrors(): boolean {
        return this.control && this.control.errors &&
            (this.control.dirty || this.control.touched);
    }

    listErrors(): string[] {
        return Object.keys(this.control.errors)
            .map(field => this.getMessage(field, this.control.errors[field]));
    }

    private getMessage(type: string, params: any) {
        return ErrorComponent.errorMessages[type](params);
    }
}