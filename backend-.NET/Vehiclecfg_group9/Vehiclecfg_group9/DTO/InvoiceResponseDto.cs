using System;

namespace Vehiclecfg_group9.DTO
{
    public class InvoiceResponseDto
    {
        public long InvId { get; set; }

        public DateTime? InvDate { get; set; }

        public double? NetAmt { get; set; }

        public double? Tax { get; set; }

        public double? TotalAmt { get; set; }

        public int ModelId { get; set; }

        public int Id { get; set; }
    }
}