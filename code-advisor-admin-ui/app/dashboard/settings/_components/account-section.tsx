import { DatePickerDemo } from '@/components/dateTimePicker';
import { Form } from '@/components/ui/form';
import { zodResolver } from '@hookform/resolvers/zod';
import React, { useState } from 'react';
import { useForm } from 'react-hook-form';
import { z } from 'zod';

const formSchema = z.object({});
export default function AccountSection() {
    const [urls, setUrls] = useState([
        'https://facebook.com/sopheaktra9',
        'https://twitter.com/sopheaktra9'
    ]);

    const addNewUrl = () => {
        setUrls([...urls, '']);
    };

    const defaultValues = {
        image: null
    };

    const form = useForm<z.infer<typeof formSchema>>({
        resolver: zodResolver(formSchema),
        values: defaultValues
    });

    function onSubmit(values: z.infer<typeof formSchema>) {
        console.log(values);
    }
    return (
        <>
            {/* Main Content */}
            <div className="flex-1 p-6">
                {/* Profile Section */}
                <section>
                    <h2 className="mb-1 text-xl font-semibold">Account</h2>
                    <p className="mb-6 text-sm text-gray-500">
                        Update your account settings. Set your preferred language and
                        timezone.
                    </p>

                    <Form {...form}>
                        <form onSubmit={form.handleSubmit(onSubmit)}>
                            {/* FirstName */}
                            <div className="mb-6">
                                <label className="mb-2 block text-sm font-medium">
                                    First Name
                                </label>
                                <input
                                    type="text"
                                    defaultValue="sopheaktra"
                                    className="w-full rounded-lg border p-2 focus:border-blue-500 focus:ring-2 focus:ring-blue-500"
                                />
                                <p className="mt-2 text-sm text-gray-500">
                                    This is your public display name. It can be your real name or
                                    a pseudonym. You can only change this once every 30 days.
                                </p>
                            </div>
                            {/* LastName */}
                            <div className="mb-6">
                                <label className="mb-2 block text-sm font-medium">
                                    Last Name
                                </label>
                                <input
                                    type="text"
                                    defaultValue="sopheaktra"
                                    className="w-full rounded-lg border p-2 focus:border-blue-500 focus:ring-2 focus:ring-blue-500"
                                />
                                <p className="mt-2 text-sm text-gray-500">
                                    This is your public display name. It can be your real name or
                                    a pseudonym. You can only change this once every 30 days.
                                </p>
                            </div>
                            {/* address 1 */}
                            <div className="mb-6">
                                <label className="mb-2 block text-sm font-medium">
                                    Address 1
                                </label>
                                <input
                                    type="text"
                                    defaultValue="sopheaktra"
                                    className="w-full rounded-lg border p-2 focus:border-blue-500 focus:ring-2 focus:ring-blue-500"
                                />
                                <p className="mt-2 text-sm text-gray-500">
                                    This is your address 1
                                </p>
                            </div>
                            {/* address 2 */}
                            <div className="mb-6">
                                <label className="mb-2 block text-sm font-medium">
                                    Address 2
                                </label>
                                <input
                                    type="text"
                                    defaultValue="sopheaktra"
                                    className="w-full rounded-lg border p-2 focus:border-blue-500 focus:ring-2 focus:ring-blue-500"
                                />
                                <p className="mt-2 text-sm text-gray-500">
                                    This is your address 2
                                </p>
                            </div>
                            {/* address 2 */}
                            <div className="mb-6">
                                <label className="mb-2 block text-sm font-medium">
                                    Date of Birth
                                </label>
                                <DatePickerDemo />
                            </div>

                            {/* Update Button */}
                            <button className="w-full rounded-lg bg-black px-6 py-2 text-white transition-colors hover:bg-gray-800 sm:w-auto">
                                Update profile
                            </button>
                        </form>
                    </Form>
                </section>
            </div>
        </>
    );
}
