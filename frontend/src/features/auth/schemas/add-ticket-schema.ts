import { z } from "zod";

export const addTicketFormSchema = z.object(
    {
        description:
        z.string().max(150),
        amount:
        z.string(),
    }
);

export type AddTicketSchema = z.infer<typeof addTicketFormSchema>;